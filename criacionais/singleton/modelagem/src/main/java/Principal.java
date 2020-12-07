
/**
 * Classe cliente, que usa o objeto Singleton.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        /*Não conseguimos chamar o construtor para criar quantos objetos quisermos,
        * pois ele é intencionalmente privado. */
        //new ImpressoraFiscal();

        //Temos que obter a instância de ImpressoraFiscal por meio do método getInstance(), pois o construtor é privado
        System.out.println("Solicitando uma instância da impressora.");
        ImpressoraFiscal impressora1 = ImpressoraFiscal.getInstance();
        System.out.println(impressora1.getModelo() + ". Data/Hora Inicialização: " + impressora1.getHoraInicializacao());

        System.out.println("Aguardando alguns segundos antes de tentar obter outra instância da impressora, para simular que a aplicação está ocupada realizando alguma operação.\n");
        sleep(2);

        /*Mesmo declarando uma outra variável para a impressora, vemos que a hora de inicialização
        * é exatamente a mesma, neste caso, mostrando que o objeto é o mesmo.*/
        System.out.println("Solicitando uma instância da impressora novamente, mas veremos que é retornada a mesma instância anterior.");
        ImpressoraFiscal impressora2 = ImpressoraFiscal.getInstance();
        System.out.println(impressora2.getModelo() + ". Data/Hora Inicialização: " + impressora2.getHoraInicializacao());
    }

    /**
     * Método usado para fazer a aplicação esperar por algum tempo,
     * para simularmos uma espera entre uma chamada de {@link ImpressoraFiscal#getInstance()} e outra.
     */
    private static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
        }
    }
}
