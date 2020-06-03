package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Define uma classe onde as estratégias para
 * leitura de arquivos de retorno de boletos (como Banco do Brasil e Bradesco)
 * serão implementadas.
 *
 * <p>Cada estratégia é implementada independentemente como uma método.
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
 * apenas para guardar as implementações das estratégias
 * em um lugar centralizado. Sendo que agora, usando programação
 * funcional cada implementação nada mais é que um simples método,
 * tais métodos foram colocados aqui para organização.
 * A implementação de uma estratégia não é uma classe
 * que implementa LeituraRetorno, mas um método
 * que recebe o nome do arquivo a ser lido e retorna uma lista
 * de Boletos.</p>
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
public final class LeituraRetorno {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Construtor privado para evitar instanciar a classe,
     * pois ela não tem atributos e todos os métodos são estáticos.
     */
    private LeituraRetorno(){
        //Não faz nada intencioalmente, pois a classe não deve ser instanciada.
    }

    public static List<Boleto> lerBancoBrasil(String nomeArquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);

                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));

                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
