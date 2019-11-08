import com.manoelcampos.retornoboleto.LeituraRetorno;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) {
        ProcessarBoletos processador =
                new ProcessarBoletos(LeituraRetorno::processarLinhaBancoBrasil);

        String nomeArquivo =
                Principal.class.getResource("banco-brasil-1.csv").getPath();
        processador.processar(nomeArquivo);
    }
}
