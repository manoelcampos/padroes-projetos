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
        final var processador = new ProcessadorBoletos(ProcessadorBoletos::lerBancoBrasil);
        URI caminhoArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        processador.processar(caminhoArquivo);
    }
}
