package com.manoelcampos.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Define uma classe onde as operações para processar uma linha
 * de um arquivo de retorno de boletos (como Banco do Brasil e Bradesco)
 * serão implementadas. O projeto usa o padrão Template Method
 * para implementar apenas o processamento de uma linha individual
 * do arquivo de retorno, no lugar de processar todas as linhas do arquivo inteiro
 * em um único método.
 *
 * <p>Os métodos aqui definidos representam as operações primitivas do padrão Template Method.
 * No nosso caso, temos apenas uma operação primitiva, o processamento de uma linha
 * de um arquivo de retorno.
 * Cada método nesta classe representa uma implementação independentemente de tal operação.
 * Por mais que as diferentes implementações estejam dentro de uma mesma classe,
 * uma implementação não interfere na outra.
 * Deste modo, não estamos violando de fato o princípio Open/Closed.</p>
 *
 * <p>Perceba que nesta implementação, diferente da anterior,
 * LeituraRetorno é uma classe e não uma interface.
 * Quando se usa uma interface, espera-se que ela
 * seja implementada por alguém ou por você mesmo em algum
 * lugar. No entanto, se tivéssemos definido LeituraRetorno
 * como uma interface, não vai existir nenhuma implementação
 * de tal interface em lugar algum.
 * Isto pode tornar as coisas confusas para quem for usar
 * a interface. Ela não usada nem implementada em lugar nenhum.
 * </p>
 *
 * <p>Aqui, LeituraRetorno é usada
 * apenas para guardar as implementações das operações primitivas do padrão Template Method
 * em um lugar centralizado. Sendo que agora, usando programação
 * funcional cada implementação nada mais é que um simples método,
 * tais métodos foram colocados aqui para organização.
 * </p>
 *
 * <p>Definir LeituraRetorno como uma classe evita
 * possíveis confusões mas traz outras.
 * Quando tem-se uma classe, espera-se que ela seja instanciada
 * em algum lugar. Porém, LeituraRetorno também não será instanciada.
 * Ela não tem atributos e todos os métodos são estáticos,
 * tornando totalmente sem sentido instanciar um objeto de tal classe.
 * Mas se alguém for tentar usar a classe, vai querer instanciar um objeto dela
 * e não saberá o que fazer com ele, pois não há onde usá-lo,
 * causando confusão.
 * Para evitar esta última confusão, a classe possui um construtor
 * privado, impossibilitando qualquer instanciação.</p>
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para
 * selecionar a estratégia a ser usada para ler um determinado arquivo
 * de retorno, não quero que as estratégias sejam acessadas diretamente.
 * Somente as classes deste pacote, como a {@link EstrategiaBoletoFactory},
 * terão acesso. Assim, quem for usar este pacote para ler arquivos
 * de retorno, não tem que se preocupar com as implementações específicas.
 * Precisa apenas usar a classe {@link ProcessarBoletos}.
 * Ela solicitará à factory para selecionar a estratégia correta
 * para o arquivo de retorno de boletos informado.
 * Aqui uso a palavra "selecionar" pois, como estamos aplicando
 * programação funcional, as estratégias não são objetos,
 * mas apenas funções (métodos) dentro da classe {@link LeituraRetorno}.
 * A factory apenas seleciona a função adequada.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
final class LeituraRetorno {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Construtor privado para evitar instanciar a classe,
     * pois ela não tem atributos e todos os métodos são estáticos.
     */
    private LeituraRetorno(){
        //Não faz nada intencioalmente, pois a classe não deve ser instanciada.
    }

    static Boleto processarLinhaBancoBrasil(String[] vetor) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);

        boleto.setDataVencimento(LocalDate.parse(vetor[2], LeituraRetorno.FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], LeituraRetorno.FORMATO_DATA).atTime(0, 0, 0));

        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));
        return boleto;
    }

    static Boleto processarLinhaBradesco(String[] vetor) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        boleto.setAgencia(vetor[2]);
        boleto.setContaBancaria(vetor[3]);

        boleto.setDataVencimento(LocalDate.parse(vetor[4], LeituraRetorno.FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetor[5], LeituraRetorno.FORMATO_DATA_HORA));

        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));
        return boleto;
    }
}
