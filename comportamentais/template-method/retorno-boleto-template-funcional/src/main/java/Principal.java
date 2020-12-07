import com.manoelcampos.retornoboleto.LeituraRetorno;
import com.manoelcampos.retornoboleto.ProcessadorBoletos;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) {
        ProcessadorBoletos processador =
                new ProcessadorBoletos(LeituraRetorno::processarLinhaBancoBrasil);

        String nomeArquivo =
                Principal.class.getResource("banco-brasil-1.csv").getPath();
        processador.processar(nomeArquivo);
    }
}
