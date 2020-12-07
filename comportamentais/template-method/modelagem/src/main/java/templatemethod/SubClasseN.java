package templatemethod;

/**
 * Subclasse que fornece outra implementação específica
 * para as operações primitivas definidas na classe abstrata.
 * @author Manoel Campos da Silva Filho
 */
public class SubClasseN extends ClasseAbstrata {
    @Override
    protected void operacaoPrimitiva1() {
        //TODO: Seu código aqui.
        System.out.println("\tExecutou operação primitiva 1 na classe " + getClass().getSimpleName());
    }

    @Override
    protected void operacaoPrimitiva2() {
        //TODO: Seu código aqui.
        System.out.println("\tExecutou operação primitiva 2 na classe " + getClass().getSimpleName());
    }

    @Override
    protected void operacaoPrimitivaN() {
        //TODO: Seu código aqui.
        System.out.println("\tExecutou operação primitiva N na classe " + getClass().getSimpleName());
    }
}
