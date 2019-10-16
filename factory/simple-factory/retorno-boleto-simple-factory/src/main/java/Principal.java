import com.manoelcampos.retornoboleto.Boleto;
import com.manoelcampos.retornoboleto.LeituraRetorno;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

import java.util.function.Function;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) {
        String nomeArquivo = Principal.class.getResource("bradesco-1.csv").getPath();
        ProcessarBoletos processador = new ProcessarBoletos();
        processador.processar(nomeArquivo);

    }
}
