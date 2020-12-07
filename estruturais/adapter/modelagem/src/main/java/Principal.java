import adapter.*;

/**
 * Classe cliente, que usa o as classes que implementam o padrão Adapter.
 * Apesar das classes {@link AdaptadaAbc} e {@link AdaptadaXyz} terem interfaces
 * diferentes (diferentes assinaturas para os métodos públicos),
 * elas são usadas da mesma forma por meio dos respectivos adapters {@link AbcAdapter}
 * e {@link XyzAdapter}.
 *
 * <p>Assim, no lugar de uma hora chamar os métodos A e B para uma classe e X e Y para outra,
 * com os adapters podemos chamar os métodos 1 e 2 independentemente de qual classe desejamos usar.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        Alvo abcAdapter = new AbcAdapter();
        abcAdapter.metodo1("casa");
        abcAdapter.metodo2("vela");
        System.out.println();

        Alvo xyzAdapter = new XyzAdapter();
        xyzAdapter.metodo1("gato");
        xyzAdapter.metodo2("loja");
    }
}
