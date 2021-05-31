//Quandl
import com.jimmoores.quandl.*;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

//YahooFinance
import io.github.mainstringargs.yahooFinance.*;
import io.github.mainstringargs.yahooFinance.domain.FinancialData;

//AlphaVantage
import org.patriques.*;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.quote.StockQuotesResponse;
import org.patriques.output.quote.data.StockQuote;

import java.time.format.DateTimeFormatter;

/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem todo o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println();

        //No Yahoo Finance, as empresas brasileiras terminam com ".sa"
        cotacaoUsandoYahooFinance("MGLU3.SA"); //MGLU3 = Magazine Luiza

        cotacaoUsandoAlphaVantage("INTL"); //INTL = Intel
        cotacaoUsandoQuandl("WIKI/AAPL"); //AAPL = Apple
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://finance.yahoo.com">Yahoo Finance</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/yahoo-finance-scraper">Yahoo Finance Scrapper</a>.
     * @param codigoEmpresa
     * @see <a href="http://meumobi.github.io/stocks%20apis/2016/03/13/get-realtime-stock-quotes-yahoo-finance-api.html">Get realtime stock quotes yahoo finance API</a>
     */
    private static void cotacaoUsandoYahooFinance(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Yahoo Finance: https://finance.yahoo.com%n", codigoEmpresa);
        YahooFinanceUrlBuilder builder =
                new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codigoEmpresa);

        YahooFinanceRequest request = new YahooFinanceRequest();
        YahooFinanceData financeData = request.getFinanceData(request.invoke(builder));

        FinancialData financials = financeData.getFinancialData();
        if (financials != null) {
            System.out.printf("Data: Preço: %s %s%n", financials.getFinancialCurrency(), financials.getCurrentPrice().getRaw());
        }

        System.out.println(builder.getURL());
        System.out.println("https://query1.finance.yahoo.com/v8/finance/chart/"+codigoEmpresa+"?period1=1546311600&period2=1556593200&interval=1d&includePrePost=False");
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.alphavantage.co">AlphaVantage</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/alpha-vantage-scraper">AlphaVantage Scrapper</a>.
     * @param codigoEmpresa
     */
    private static void cotacaoUsandoAlphaVantage(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Alpha Vantage: http://www.alphavantage.co%n", codigoEmpresa);

        /*
        Verifica se existe uma variável de ambiente para a chave da API do serviço Alpha Vantage.
        Você pode se cadastrar e obter uma chave em http://www.alphavantage.co
        */
        final String s = System.getenv("ALPHAVANTAGE_APIKEY");
        final String apiKey = s == null ? "50M3AP1K3Y" : s;
        final int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);

        //Permite obter a cotação (quotes) de ações (stocks).
        StockQuotes stockQuotes = new StockQuotes(apiConnector);

        try {
            StockQuotesResponse response = stockQuotes.quote(codigoEmpresa);
            StockQuote stock = response.getStockQuote();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("Data: %s Preço: %s%n", formatter.format(stock.getLatestTradingDay()), stock.getPrice());
        } catch (AlphaVantageException e) {
            System.out.println("Erro ao solicitar cotação da empresa " + codigoEmpresa + ": " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.quandl.com">Quandl</a>
     * por meio da biblioteca <a href="http://quandl4j.org">quandl4j</a>.
     * @param codigoEmpresa
     */
    private static void cotacaoUsandoQuandl(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Quandl: http://quandl.com/%n", codigoEmpresa);
        ClassicQuandlSession session = ClassicQuandlSession.create();
        DataSetRequest request = DataSetRequest.Builder
                                        .of(codigoEmpresa)
                                        .withMaxRows(1)
                                        .build();
        TabularResult result = session.getDataSet(request);
        if(result.size() > 0) {
            Row row = result.get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = formatter.format(row.getLocalDate("Date"));
            System.out.printf("Data: %s Preço: %s%n", date, row.getDouble("Close"));
            //System.out.println(result.toPrettyPrintedString());
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
