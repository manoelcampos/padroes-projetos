import strategy.ComportamentoA1;
import strategy.ComportamentoA2;
import strategy.ComportamentoB1;
import strategy.Estrategista;

/**
 * Classe cliente, que usa as classes que implementam o padrão Strategy
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        //Instancia a classe estrategista informando os comportamentos a serem usados
        Estrategista estrategista = new Estrategista(new ComportamentoA2(), new ComportamentoB1());
        estrategista.getComportamentoA().executarComportamentoA();
        estrategista.getComportamentoB().executarComportamentoB();

        System.out.println();
        //Altera o comportamento A em tempo de execução
        estrategista.setComportamentoA(new ComportamentoA1());
        estrategista.getComportamentoA().executarComportamentoA();
    }
}
