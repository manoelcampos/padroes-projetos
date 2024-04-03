import com.manoelcampos.retornoboleto.LeituraRetorno;
import com.manoelcampos.retornoboleto.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        var processador = new ProcessadorBoletos(LeituraRetorno::processarLinhaBancoBrasil);

        URI nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        processador.processar(nomeArquivo);
    }
}
