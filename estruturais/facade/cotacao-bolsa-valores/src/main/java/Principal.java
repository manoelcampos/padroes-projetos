//Quandl
import com.jimmoores.quandl.*;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

//AlphaVantage
import io.github.mainstringargs.alphavantagescraper.AlphaVantageConnector;
import io.github.mainstringargs.alphavantagescraper.StockQuotes;
import io.github.mainstringargs.alphavantagescraper.output.AlphaVantageException;

//YahooFinance
import io.github.mainstringargs.yahooFinance.*;

import java.time.format.DateTimeFormatter;

/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 *
 * <p>
 * Observe que os métodos {@link #cotacaoUsandoYahooFinance(String)},
 * {@link #cotacaoUsandoAlphaVantage(String)} e
 * {@link #cotacaoUsandoQuandl(String)} não estão retornando nada, pois
 * isto é apenas um exemplo.
 * Se formos usar esta implementação em uma aplicação com interface gráfica (e não console),
 * o usuário não vai ver os prints inseridos.
 * Por isso neste caso, os método pra serem úteis para qualquer tipo de app (web, mobile, desktop, console, etc),
 * precisam retornar algum dado. Se tivermos uma app web, por exemplo, podemos então pegar estes dados e exibir
 * em uma página HTML.
 * Como você irá remodelar o código para aplicar o projeto, você precisa fazer estas alterações.
 * </p>
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println();

        try {
            //No Yahoo Finance, as empresas brasileiras terminam com ".sa"
            cotacaoUsandoYahooFinance("MGLU3.SA"); //MGLU3 = Magazine Luiza
            cotacaoUsandoAlphaVantage("INTC"); //INTC = Intel
            cotacaoUsandoQuandl("WIKI/AAPL"); //AAPL = Apple
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://finance.yahoo.com">Yahoo Finance</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/yahoo-finance-scraper">Yahoo Finance Scrapper</a>.
     * @param codEmpresa
     * @see <a href="http://meumobi.github.io/stocks%20apis/2016/03/13/get-realtime-stock-quotes-yahoo-finance-api.html">Get realtime stock quotes yahoo finance API</a>
     */
    private static void cotacaoUsandoYahooFinance(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s pelo Yahoo Finance: https://finance.yahoo.com%n", codEmpresa);
        var builder =
                new YahooFinanceUrlBuilder()
                        .modules(YahooFinanceModules.values())
                        .symbol(codEmpresa);

        var request = new YahooFinanceRequest();
        var financeData = request.getFinanceData(request.invoke(builder));

        var financialData = financeData.getFinancialData();
        if (financialData == null)
            throw new RuntimeException("Não foi possível obter a cotação para a empresa " + codEmpresa);

        System.out.printf(
            "Preço: %s %s%n",
            financialData.getFinancialCurrency(),
            financialData.getCurrentPrice().getRaw());

        /*
        System.out.println(builder.getURL());
        System.out.println("https://query1.finance.yahoo.com/v8/finance/chart/"+codEmpresa+"?period1=1546311600&period2=1556593200&interval=1d&includePrePost=False");
        */
        System.out.println("---------------------------------------------------------------------------------");
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.alphavantage.co">AlphaVantage</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/alpha-vantage-scraper">AlphaVantage Scrapper</a>.
     * @param codEmpresa
     */
    private static void cotacaoUsandoAlphaVantage(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s pelo Alpha Vantage: http://www.alphavantage.co%n", codEmpresa);

        /*
        Verifica se existe uma variável de ambiente para a chave da API do serviço Alpha Vantage.
        Você pode se cadastrar e obter uma chave em http://www.alphavantage.co
        */
        final String s = System.getenv("ALPHAVANTAGE_APIKEY");
        final String apiKey = s == null ? "50M3AP1K3Y" : s;
        final int timeout = 3000;
        var apiConnector = new AlphaVantageConnector(apiKey, timeout);

        //Permite obter a cotação (quotes) de ações (stocks).
        var stockQuotes = new StockQuotes(apiConnector);

        try {
            var response = stockQuotes.quote(codEmpresa);
            var stockQuote = response.getStockQuote();
            var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf(
                "Data: %s Preço: %s%n",
                dateFormatter.format(stockQuote.getLatestTradingDay()), stockQuote.getPrice());
        } catch (AlphaVantageException e) {
            throw new RuntimeException("Erro ao solicitar cotação da empresa " + codEmpresa + ": " + e.getMessage(), e);
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.quandl.com">Quandl</a>
     * por meio da biblioteca <a href="http://quandl4j.org">quandl4j</a>.
     * @param codEmpresa
     */
    private static void cotacaoUsandoQuandl(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s pelo Quandl: http://quandl.com%n", codEmpresa);
        var session = ClassicQuandlSession.create();
        var request = DataSetRequest
                        .Builder
                        .of(codEmpresa)
                        .withMaxRows(1)
                        .build();
        var tabularResult = session.getDataSet(request);
        if (tabularResult.size() == 0)
            throw new RuntimeException("Não foi possível obter a cotação para a empresa " + codEmpresa);

        Row row = tabularResult.get(0);
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = formatter.format(row.getLocalDate("Date"));
        System.out.printf("Data: %s Preço: %s%n", date, row.getDouble("Close"));
        //System.out.println(result.toPrettyPrintedString());
        System.out.println("---------------------------------------------------------------------------------");
    }
}
