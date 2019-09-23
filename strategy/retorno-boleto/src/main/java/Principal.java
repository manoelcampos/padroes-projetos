import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

/**
 * Classe para ver o funcionamento da leitura de boletos.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        /*Instancia o objeto estrategista ProcessarBoletos,
        * indicando qual estratégia de leitura de boletos ele vai usar agora.
        * Neste caso, estamos iniciando com a leitura de boletos do Banco do Brasil.*/
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());

        /*No lugar de passar o caminho absoluto do arquivo a ser lido (que pode mudar e vai fazer
        * com que a aplicação não funcione em qualquer máquina, sem atualizar o caminho),
        * é usado o método getResource para obter o caminho de um arquivo na pasta resources.
        * Assim, sem pre que sua aplicação java precisar ler um arquivo, o ideal é colocá-lo
        * dentro desta pasta e então usar a linha abaixo para obter o caminho correto do arquivo
        * na máquina atual.
        *
        * OBS: Como a classe Principal (usada abaixo como auxiliar no processo de descoberta
        * do caminho de um arquivo) não está dentro de nenhum pacote, o arquivo a ser lido
        * também não deve estar dentro de nenhum pacote (deve estar na raiz de resources).
        * Se a classe Principal (ou qualquer uma que usarmos abaixo) estiver em um pacote,
        * o arquivo também precisará estar dentro do mesmo pacote dentro da pasta resources.*/
        String nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");

        processador.processar(nomeArquivo);
    }
}
