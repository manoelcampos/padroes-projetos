package simplefactory;

/**
 * Esta é uma fábrica que implementa o padrão Simple Factory.
 * O nome da classe deve ser alterado de acordo com o problema sendo resolvido.
 * @author Manoel Campos da Silva Filho
 */
public class SimpleFactory {
    /**
     * Método que representa a fábrica de fato.
     * O nome do método pode ser newObject, newInstance ou algo mais
     * específico como "new" + o nome da classe de objetos que o método instancia,
     * como newExportador, newTabela, etc.
     *
     * <p>O método é normalmente definido como estático para evitar
     * que tenhamos que instanciar a fábrica antes de podermos
     * instanciar objetos.</p>
     * @return
     */
    public static TipoAbstrato newObject() {
        /*TODO: Defina a lógica para decidir qual classe será instanciada.
                Aqui estamos apenas retornando uma classe escolhida aleatoriamente.
                Portanto, a lógica neste método não tem abosolutamente
                nada a ver com uma implementação de um problema real.
                Para cada problema, a classe que de fato será instanciada será
                definida usando regras específicas.
        */
        final int rand = (int)(Math.random() * 3 + 1);
        switch (rand){
            case 1: return new TipoConcreto1();
            case 2: return new TipoConcreto2();
            default: return new TipoConcretoN();
        }
    }
}
