package factorymethod;

/**
 * @author Manoel Campos da Silva Filho
 */
public class CriadorConcreto1 extends Criador {
    /**
     * O {@link CriadorConcreto1} é que sabe que tipo de objeto
     * ele irá instanciar. O método pode definir uma lógica
     * para selecionar qual tipo de objeto será instanciada.
     * Aqui, não estamos incluíndo lógica alguma, apenas
     * instanciando um objeto específico.
     * @return
     */
    @Override
    public TipoAbstrato newObject() {
        return new TipoConcreto1();
    }
}
