package io.github.manoelcampos.realrandom;

import com.manoelcampos.anuquantumnumbers.AnuQuantumNumberClient;
import com.manoelcampos.anuquantumnumbers.NumberType;
import com.manoelcampos.randomorg.RandomOrgClient;

/**
 * Classe principal para rodar e "testar" sua implementação.
 * O código precisa ser alterado para estar de acordo
 * com implementação do padrão de projeto que você aplicar.
 */
public class Principal {
    public static void main(final String[] args) {
        geradorRandomOrg();
        geradorQuantumNumbers();
    }

    /**
     * Gera números aleatórios com o serviço https://random.org
     */
    private static void geradorRandomOrg() {
        final var randomService = new RandomOrgClient();
        final int n = 4;
        final int minValue = 1;
        final int maxValue = 10;
        System.out.printf(
                "%nGerando %d números realmente aleatórios entre [%d..%d] usando %s%n",
                n, minValue, maxValue, randomService.getClass().getSimpleName());
        for (final int number : randomService.generateIntegers(n, minValue, maxValue)) {
            System.out.println(number);
        }
    }

    /**
     * Gera números aleatórios com o serviço https://quantumnumbers.anu.edu.au
     */
    private static void geradorQuantumNumbers() {
        final var randomService = new AnuQuantumNumberClient();
        final int n = 4;
        System.out.printf(
                "%nGerando %d números realmente aleatórios entre [0..%d] usando %s%n",
                n, NumberType.uint16.maxValue(), randomService.getClass().getSimpleName());
        for (final int number : randomService.generateInt16Numbers(n)) {
            System.out.println(number);
        }
    }

}
