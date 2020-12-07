
import com.manoelcampos.modelo.Paciente;
import com.manoelcampos.modelo.PacienteBuilder;

/**
 * Classe principal que inicializa o sistema
 * e mostra como instanciar {@link Paciente}s usando
 * o padrão Builder gerado automaticamente por meio da biblioteca
 * <a href="http://immutables.github.io/factory.html">Immutables</a>.
 * Veja a documentação da classe {@link Paciente} para mais detalhes.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        /*
        //Esta seria a forma de instanciar um paciente se o construtor
        //que recebe todos os parâmetros fosse público.
        //Usando o construtor (caso ele fosse público), conseguimos preencher todos os atributos obrigatórios.
        //No entanto, a chamada é simplesmente longa e confusa.
        Paciente p1 = new Paciente(1, "Manoel", 'M', "89278102971", "123.456", "SSP-TO", "Palmas", "TO",   80, 1.85);

        //Esta seria a forma de instanciar um Paciente se houvesse um construtor público sem parâmetros.
        //Temos que instanciar o objeto e depois setar os atributos individualmente chamando
        //os respectivos setters.
        //Porém, desta forma, algum atributo obrigatório pode deixar de ser preenchido e não
        //temos como obrigar tal preenchimento.
        Paciente p2 = new Paciente();
        p2.setNome("Breno");
        p2.setSexo('M');
        p2.setId(2);
        */

        /**
         * Esta é a forma de instanciar um paciente usando um Builder.
         * Se algum atributo obrigatório (como CPF) for esquecido, ao chamar
         * o método build(), ocorrerá uma exceção pois o builder
         * vai chamar o construtor privado de {@link Paciente}, que recebe todos os parâmetros.
         * Se algum deles for null or vazio, uma exceção será lançada.
         * Apesar de termos múltiplas linhas abaixo, isto é uma única instrução (temos apenas um ponto-e-vírgula).
         * Em tal instrução, estamos instanciar um builder para construir um paciente,
         * passando os valores dos atributos obrigatórios e desejados para o builder
         * e então chamando o método build() para construir (instanciar) um Paciente
         * com os dados informados.
         */
        Paciente paciente =
                new PacienteBuilder()
                        .nome("Manoel")
                        .sexo('F')
                        .cpf("123.012.918-00")
                        .cidade("Palmas").uf("TO")
                        .altura(1.7)
                        .build();

        System.out.println(paciente);
    }
}
