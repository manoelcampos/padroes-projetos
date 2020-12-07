import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessadorBoletos;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        ProcessadorBoletos processador = new LeituraRetornoBancoBrasil();
        String nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").getPath();
        processador.processar(nomeArquivo);
    }
}
