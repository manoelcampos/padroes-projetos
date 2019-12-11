package adapter;

/**
 * Uma das classes a serem adaptadas, que precisam
 * que sua interface seja uniformizada.
 *
 * @author Manoel Campos da Silva Filho
 */
public class AdaptadaAbc {
    void metodoA(String param){
        System.out.print("Chamando método A da classe " + getClass().getSimpleName() + " com parâmetro " + param + ". ");
    }

    void metodoB(String param){
        System.out.print("Chamando método B da classe " + getClass().getSimpleName() + " com parâmetro " + param + ". ");
    }

}
