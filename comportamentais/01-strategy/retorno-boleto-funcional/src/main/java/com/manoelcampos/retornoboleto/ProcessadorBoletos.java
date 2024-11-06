package com.manoelcampos.retornoboleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Implementação do processamento de arquivos de retorno
 * de boletos bancários usando programação funcional no Java 8+.
 *
 * <p>Esta versão inclui as implementações
 * dos comportamentos, as funções de leitura de arquivos
 * de boleto, todas dentro desta classe estrategista.
 * O ideal seria que tais implementações ficassem
 * uma uma classe separada.
 * Independentemente de tal classe ser criada ou não,
 * como cada implementação está totalmente contida dentro
 * de um único método, uma não interfere na outra
 * e assim não estamos violando o Open/Closed Principle (OCP).
 * </p>
 *
 *
 * @author Manoel Campos da Silva Filho
 */
public class ProcessadorBoletos {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * {@link Function} que possui a implementação
     * da estratégia para leitura do arquivo de retorno de boleto
     * bancário para um banco específico (como Banco do Brasil, Bradesco, etc).
     */
    private Function<URI, List<Boleto>> leituraRetorno;

    public ProcessadorBoletos(Function<URI, List<Boleto>> leituraRetorno){
	    this.leituraRetorno = leituraRetorno;
    }

    /**
     * Implementação do comportamento (estratégia)
     * de leitura de arquivos de boleto do Banco do Brasil.
     * @param caminhoArquivo
     * @return
     */
    public static List<Boleto> lerBancoBrasil(URI caminhoArquivo) {
        try{
            var listaLinhas = Files.readAllLines(Paths.get(caminhoArquivo));
            List<Boleto> boletos = new ArrayList<>();
            for (String linha : listaLinhas) {
                String[] vetor = linha.split(";");
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

    public void processar(URI caminhoArquivo){
        List<Boleto> boletos = leituraRetorno.apply(caminhoArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }
}
