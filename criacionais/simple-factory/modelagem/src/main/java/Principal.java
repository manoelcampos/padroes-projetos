import simplefactory.SimpleFactory;
import simplefactory.TipoAbstrato;

/**
 * Classe cliente, que usa a Simple Factory.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        TipoAbstrato objeto = SimpleFactory.newObject();
        System.out.println("Tipo de objeto criado: " + objeto.getClass().getSimpleName());
    }
}
