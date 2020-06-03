import com.manoelcampos.retornoboleto.LeituraRetorno;
import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 *
 * <p>Perceba que a forma de utilizar as classes não mudou
 * nada em relação à implementação utilizando apenas o padrão Strategy.
 * No entanto, observando o código das classes envolvidas e a documentação,
 * podemos ver que existem grandes diferenças.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        String nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").getPath();
        processador.processar(nomeArquivo);
    }
}
