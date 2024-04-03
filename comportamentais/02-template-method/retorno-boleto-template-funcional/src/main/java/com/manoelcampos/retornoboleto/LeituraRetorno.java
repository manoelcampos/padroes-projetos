package com.manoelcampos.retornoboleto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Define uma classe onde as operações para processar uma linha
 * de um arquivo de retorno de boletos (como Banco do Brasil e Bradesco)
 * serão implementadas. Tal implementação usa o padrão Template Method
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
 * @author Manoel Campos da Silva Filho
 */
//tag::class-start[] 
public final class LeituraRetorno {
//end::class-start[]     
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Construtor privado para evitar instanciar a classe,
     * pois ela não tem atributos e todos os métodos são estáticos.
     */
    //tag::method-start[]  
    private LeituraRetorno(){
        /*Não faz nada intencioalmente: a classe não deve ser instanciada.*/
    }

    public static Boleto processarLinhaBancoBrasil(String[] vetor) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        //end::method-start[]  

        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));

        //tag::method-end[]  
        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));
        return boleto;
    }
}
//end::method-end[]  
