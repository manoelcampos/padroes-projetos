package adapter;

/**
 * Interface que uniformiza as classes adaptadas,
 * que deve ser implementada pelos adaptadores.
 *
 * <p>
 * O nome da classe e métodos, quantidade de métodos
 * e parâmetros, tipos de parâmetros e retornos devem ser definidos
 * de acordo com o problema sendo resolvido.
 * </p>
 *
 * <p>A interface define os métodos comuns que todos os adaptadores devem ter.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public interface Alvo {
    void metodo1(String param);
    void metodo2(String param);
}
