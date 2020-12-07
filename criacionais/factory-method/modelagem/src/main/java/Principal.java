import factorymethod.Criador;
import factorymethod.CriadorConcreto1;
import factorymethod.CriadorConcreto2;

/**
 * Classe cliente, que usa a fábrica.
 * Você pode instanciar as diferentes fábricas dentro do main (ou qualquer outro lugar),
 * como {@link CriadorConcreto2} no lugar de  {@link CriadorConcreto1}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        Criador criador = new CriadorConcreto1();
        criador.useObject();
    }
}
