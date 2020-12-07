package adapter;

/**
 * Outra classe a ser adaptada, que precisa
 * que sua interface seja uniformizada.
 *
 * @author Manoel Campos da Silva Filho
 */
public class AdaptadaXyz {
    void metodoX(String param){
        System.out.print("Chamando método X da classe " + getClass().getSimpleName() + " com parâmetro " + param + ". ");
    }

    void metodoY(String param){
        System.out.print("Chamando método Y da classe " + getClass().getSimpleName() + " com parâmetro " + param + ". ");
    }

}
