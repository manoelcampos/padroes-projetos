import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.Row;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;
import io.github.mainstringargs.yahooFinance.YahooFinanceData;
import io.github.mainstringargs.yahooFinance.YahooFinanceModules;
import io.github.mainstringargs.yahooFinance.YahooFinanceRequest;
import io.github.mainstringargs.yahooFinance.YahooFinanceUrlBuilder;
import io.github.mainstringargs.yahooFinance.domain.FinancialData;
import org.patriques.AlphaVantageConnector;
import org.patriques.BatchStockQuotes;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.quote.BatchStockQuotesResponse;
import org.patriques.output.quote.data.StockQuote;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println();

        //No Yahoo Finance, as empresas brasileiras terminam com ".sa"
        cotacaoUsandoYahooFinance("ITUB4.SA"); //ITUB4 = Itaú

        cotacaoUsandoAlphaVantage("INTL"); //INTL = Intel
        cotacaoUsandoQuandl("WIKI/AAPL"); //AAPL = Apple
    }

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

        System.out.println("---------------------------------------------------------------------");
    }

    private static void cotacaoUsandoAlphaVantage(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Alpha Vantage: http://www.alphavantage.co%n", codigoEmpresa);

        /*
        Verifica se existe uma variável de ambiente para a chave da API do serviço Alpha Vantage.
        Você pode se cadastrar e obter uma chave em http://www.alphavantage.co
        */
        final String s = System.getenv("ALPHAVANTAGE_APIKEY");
        final String apiKey = s == null ? "50M3AP1K3Y" :
                s;
        final int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);

        //Permite obter a cotação (quotes) de ações (stocks).
        BatchStockQuotes stockQuotes = new BatchStockQuotes(apiConnector);

        try {
            BatchStockQuotesResponse response = stockQuotes.quote(codigoEmpresa);
            List<StockQuote> stockQuoteList = response.getStockQuotes();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            stockQuoteList.forEach(stock -> System.out.printf("Data: %s Preço: %s%n", formatter.format(stock.getTimestamp()), stock.getPrice()));
        } catch (AlphaVantageException e) {
            System.out.println("Erro ao solicitar cotação da empresa " + codigoEmpresa + ": " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------------------");
    }

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
