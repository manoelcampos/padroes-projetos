import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

import java.util.Random;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        /*Seed (semente) é o valor inicial a ser utilizado pelos geradores de números aleatórios.
        * Se for utilizada uma mesma seed ao executar a aplicação várias vezes, os
        * mesmos exatos valores serão gerados.
        * Alterando a seed a cada execução, a sequência de valores muda.
        */
        final long seed = 123;

        RealDistribution normalRandom = new NormalDistribution();
        normalRandom.reseedRandomGenerator(seed);

        RealDistribution logNormalRandom = new LogNormalDistribution();
        logNormalRandom.reseedRandomGenerator(seed);

        Random random = new Random(seed);

        //Total de números a serem gerados em cada gerador
        final int TOTAL_NUMEROS = 4;
        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            System.out.println("Número aleatório seguindo distribuição Normal usando biblioteca Apache Commons Math: " + normalRandom.sample(12));
            System.out.println("Número aleatório seguindo distribuição Exponencial usando biblioteca Apache Commons Math: " + logNormalRandom.sample());
            System.out.println("Número aleatório seguindo distribuição Uniforme usando classe Random: " + random.nextDouble());
            System.out.println();
        }
    }

}
