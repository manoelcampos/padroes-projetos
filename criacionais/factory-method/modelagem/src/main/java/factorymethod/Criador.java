package factorymethod;

/**
 * Esta é uma fábrica que implementa o padrão Factory Method.
 * O nome da classe deve ser alterado de acordo com o problema sendo resolvido.
 * @author Manoel Campos da Silva Filho
 */
public abstract class Criador {
    /**
     * Método que representa a fábrica de fato.
     * O nome do método pode ser newObject, newInstance ou algo mais
     * específico como "new" + o nome da classe de objetos que o método instancia,
     * como newExportador, newTabela, etc.
     *
     * <p>Ele é abstrato, logo as subclasses de {@link Criador} é que
     * devem definir como e qual objeto instanciar.
     * O método pode ter parâmetros, de acordo com as necessidades do problema
     * a ser resolvido.</p>
     *
     * @return
     */
    public abstract TipoAbstrato newObject();

    /**
     * Um método qualquer que utilizará
     * os objetos criados pelo método {@link #newObject()}.
     * O nome do método e parâmetros vão depender do problema sendo resolvido.
     * Aqui, estamos apenas imprimindo a class do objeto instanciado.
     */
    public void useObject(){
        TipoAbstrato objeto = newObject();
        System.out.println("Objeto instanciado pela fábrica " + getClass().getSimpleName() + ": " + objeto.getClass().getSimpleName());
    }

}
