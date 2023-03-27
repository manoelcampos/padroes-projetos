import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        ProcessadorBoletos processador = new LeituraRetornoBancoBrasil();
        URI nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        processador.processar(nomeArquivo);
    }
}
