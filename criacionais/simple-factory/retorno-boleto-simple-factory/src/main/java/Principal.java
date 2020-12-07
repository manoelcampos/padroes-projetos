import com.manoelcampos.retornoboleto.ProcessarBoletos;

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
