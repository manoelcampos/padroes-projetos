package templatemethod;

/**
 * Classe que implementa o Template Method.
 * O nome da classe deve ser alterado de acordo com o problema sendo resolvido.
 * @author Manoel Campos da Silva Filho
 */
public abstract class ClasseAbstrata {

    /**
     * Este é o Template Method.
     * Ele executa um conjunto de operações em uma ordem específica,
     * onde algumas destas operações são implementadas apenas nas subclasses.
     * O tipo de retorno e possíveis parâmetros do método deve ser definido
     * de acordo com o problema sendo resolvido.
     *
     * <p>O método é definido como final para evitar que subclasses alterem seu código.
     * Isto iria contra o que o padrão está buscando resolver: evitar
     * que as subclasses omitam alguma operação primitiva ou alterem a ordem
     * em que elas devem ser executada neste método.</p>
     */
    public final void templateMethod(){
        System.out.println("Executando o Template Method a partir da classe: " + getClass().getSimpleName());
        /*
        * Antes, depois e entre as operações primitivas
        * pode haver qualquer outra operação como operações
        * aritméticas, chamadas de funções e qualquer outro código válido.
        */
        operacaoPrimitiva1();
        operacaoPrimitiva2();
        operacaoPrimitivaN();
        System.out.println();
    }

    /**
     * Representa uma operação qualquer que deve ser implementada
     * pelas subclasses.
     *
     * O tipo de retorno e possíveis parâmetros do método deve ser definido
     * de acordo com o problema sendo resolvido.
     */
    protected abstract void operacaoPrimitiva1();

    /**
     * Representa uma operação qualquer que deve ser implementada
     * pelas subclasses.
     *
     * O tipo de retorno e possíveis parâmetros do método deve ser definido
     * de acordo com o problema sendo resolvido.
     */
    protected abstract void operacaoPrimitiva2();

    /**
     * Representa uma operação qualquer que deve ser implementada
     * pelas subclasses.
     *
     * O tipo de retorno e possíveis parâmetros do método deve ser definido
     * de acordo com o problema sendo resolvido.
     */
    protected abstract void operacaoPrimitivaN();
}
