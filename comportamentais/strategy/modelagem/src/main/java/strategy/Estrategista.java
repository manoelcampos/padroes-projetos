package strategy;

/**
 * Classes que usa as estratégias (comportamentos).
 * Subclasses são opcionais e só vão existir
 * se forem necessárias para o problema que estiver resolvendo.
 * Esta classe possui dois comportamentos: {@link #comportamentoA} e {@link #comportamentoB}.
 * No entanto, o total de comportamentos também depende do problema sendo resolvido.
 * @author Manoel Campos da Silva Filho
 */
public class Estrategista {
    private ComportamentoA comportamentoA;
    private ComportamentoB comportamentoB;

    /**
     * Instancia a classe Estrategista, definindo quais serão os comportamentos
     * (estratégias) que ela utilizará.
     * @param comportamentoA
     * @param comportamentoB
     */
    public Estrategista(ComportamentoA comportamentoA, ComportamentoB comportamentoB){
        this.comportamentoA = comportamentoA;
        this.comportamentoB = comportamentoB;
    }

    public ComportamentoA getComportamentoA() {
        return comportamentoA;
    }

    /**
     * Permite alterar o comportamento A em tempo de execução.
     * @param comportamentoA
     */
    public void setComportamentoA(ComportamentoA comportamentoA) {
        this.comportamentoA = comportamentoA;
        System.out.println("Alterando comportamento A para a implementação " + comportamentoA.getClass().getSimpleName());
    }

    public ComportamentoB getComportamentoB() {
        return comportamentoB;
    }

    /**
     * Permite alterar o comportamento B em tempo de execução.
     * @param comportamentoB
     */
    public void setComportamentoB(ComportamentoB comportamentoB) {
        this.comportamentoB = comportamentoB;
        System.out.println("Alterando comportamento B para a implementação " + comportamentoB.getClass().getSimpleName());
    }
}
