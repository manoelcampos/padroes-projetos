import com.manoelcampos.retornoboleto.ProcessarBoletos;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) {
        /*Tente carregar o arquivo "itau-1.csv" e veja que,
        * como não existe uma classe para ler o formato de arquivos do
        * banco Itaú, ocorrerá uma exceção informando isto.*/
        String nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").getPath();
        ProcessarBoletos processador = new ProcessarBoletos();
        processador.processar(nomeArquivo);
    }
}
