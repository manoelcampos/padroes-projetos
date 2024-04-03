package adapter;

/**
 * Classe que implementa um Adapter para a classe {@link AdaptadaAbc},
 * tornando a interface de tal classe compatível com {@link Alvo}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class XyzAdapter implements Alvo {
    private final AdaptadaXyz adaptadaXyz;

    public XyzAdapter(){
        adaptadaXyz = new AdaptadaXyz();
    }

    @Override
    public void metodo1(String param) {
        adaptadaXyz.metodoX(param);
        System.out.println("O método foi chamado indiretamente a partir do método 1 do adaptador " + getClass().getSimpleName());
    }

    @Override
    public void metodo2(String param) {
        adaptadaXyz.metodoY(param);
        System.out.println("O método foi chamado indiretamente a partir do método 2 do adaptador " + getClass().getSimpleName());
    }
}
