import java.time.LocalTime;

/**
 * Classe que simula a comunicação com uma impressora fiscal.
 * A classe implementa o padrão Singleton para impedir que existam
 * várias instâncias da impressora, com possíveis diferentes configurações.
 * Múltiplas instâncias neste caso só aumentariam o consumo de memória
 * desnecessariamente, uma vez que tendo-se uma única instância da
 * classe, podemos fazer comunicação com a impressora a partir de qualquer lugar do sistema.
 */
public class ImpressoraFiscal {
    /**
     * Atributo estático que armazenará a única instância
     * possível para a classe {@link ImpressoraFiscal},
     * quando o método {@link #getInstance()} for chamado
     * pela primeira vez.
     */
    private static ImpressoraFiscal instance;

    /**
     * @see #getModelo()
     */
    private final String modelo;

    /**
     * @see #getHoraInicializacao()
     */
    private LocalTime horaInicializacao;

    /**
     * Construtor privado para impedir que a classe seja instanciada
     * diretamente, o que permitiria que vários objetos fossem criados.
     * Neste caso, estamos apenas inicializando alguns atributos para simular
     * o funcionamento da impressora.
     */
    private ImpressoraFiscal(){
        this.modelo = "Impressora Bematch v10.4.0";
        this.horaInicializacao = LocalTime.now();
    }

    /**
     * Cria um objeto caso nenhum tenha sido criado ainda,
     * ou apenas retorna o objeto único previamente criado.
     *
     * <p>
     * <b>NOTA</b>: Esta é uma implementação básica que não garante que
     * apenas um objeto será criado se a classe for utilizada por múltiplas {@link Thread}s,
     * permitindo que a aplicação execute tarefas simultâneas em diferentes CPUs.
     * </p>
     *
     * @return
     */
    public static ImpressoraFiscal getInstance(){
        //Se nenhuma instância foi criada, cria uma e armazena no atributo "instance".
        if(instance == null){
            instance = new ImpressoraFiscal();
        }

        //Retorna a instância única
        return instance;
    }

    /**
     * Obtém o modelo da impressora (apenas simulado).
     * @return
     */
    public String getModelo(){
        return modelo;
    }

    /**
     * Obtém a Data e hora que a impressora foi ligada.
     * Como só podemos criar um objeto desta classe,
     * mesmo que chamemos o método {@link #getInstance()}
     * várias vezes, em diferentes momentos e locais,
     * ao imprimir a {@link #horaInicializacao},
     * veremos que o valor é o mesmo.
     * Isto mostra que temos um único objeto em memória,
     * independentemente de termos diversas variáveis do tipo {@link ImpressoraFiscal}.
     */
    public LocalTime getHoraInicializacao() {
        return horaInicializacao;
    }
}
