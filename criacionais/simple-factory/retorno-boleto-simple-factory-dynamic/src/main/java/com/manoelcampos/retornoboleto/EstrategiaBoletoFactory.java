package com.manoelcampos.retornoboleto;

import org.apache.commons.text.WordUtils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que implementa uma Simple Factory
 * para encapsular a lógica de criação das estratégias
 * de leitura de arquivo de retorno de boleto bancário.
 *
 * <p>Observe que a classe e o método {@link #newStrategy(String)}
 * foram definidos com visibilidade package
 * pois, neste caso, não quero que a classe seja utilizada
 * fora do pacote.
 * Assim, somente classes como {@link ProcessarBoletos} podem
 * acessar esta factory.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class EstrategiaBoletoFactory {
    /**
     * Construtor privado para impedir que a fábrica
     * seja instanciada, pois o único método dela
     * é estático.
     */
    private EstrategiaBoletoFactory(){/**/}

    /**
     * Cria uma instância da estratégia ({@link LeituraRetorno}) para
     * processamento de um determinado tipo de arquivo de retorno.
     * A estratégia é automaticamente selecionada a partir
     * do nome do arquivo que deve possuir o nome do banco.
     *
     * <p>Para bancos que tenham nomes compostos, como Banco do Brasil,
     * as preposições (como "do") não devem ser incluídas no nome do arquivo
     * e as palavras separadas por hífen. Por fim, o nome do arquivo
     * deve terminar com uma numeração separada por hífen.
     * Por exemplo: Banco-Brasil-1.csv.
     * Nomes de arquivos inválidos incluem: BancoBrasil.csv, BancoBrasil-1.csv, BancoBrasil1.csv,
     * bancobrasil.csv, etc.</p>
     *
     * <p>Nomes de bancos que possuem acento (como Itaú) não devem incluir os acentos
     * no nome do arquivo nem da classe de leitura de tal arquivo.
     * Assim, para o banco Itaú, um arquivo válido seria itau-1.csv,
     * devendo existir a classe LeituraRetornoItau para processar tal arquivo.
     * </p>
     *
     * @param caminhoArquivo caminho completo do arquivo de retorno de boletos bancários de um determinado banco,
     *                       cujo nome do banco deve estar dentro do nome do arquivo.
     * @return
     */
    static LeituraRetorno newStrategy(final String caminhoArquivo){
        final String nomeBanco = getNomeBanco(caminhoArquivo);
        final String nomePacote = LeituraRetorno.class.getPackage().getName();
        final String nomeClasseEstrategia = nomePacote +".LeituraRetorno" + nomeBanco;
        try {
            /*Verifica se uma classe com o nome LeituraRetornoNomeBanco existe
            * (onde NomeBanco é descoberto automaticamente a partir do nome do arquivo)
            * e então carrega tal classe dinamicamente (em tempo de execução).
            * Assim, a classe a ser utilizada não é fixa, ela muda de acordo
            * com o arquivo informado.*/
            Class classeEstrategia = Class.forName(nomeClasseEstrategia);

            //Cria uma instância da classe descoberta dinamicamente.
            return (LeituraRetorno)classeEstrategia.newInstance();
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(
                "Classe " + nomeClasseEstrategia + " não existe para processar arquivo " +
                caminhoArquivo + " do " + nomeBanco);
        } catch (IllegalAccessException e) {
            throw new UnsupportedOperationException("Não há permissão para instanciar a estratégia para leitura do arquivo de retorno", e);
        } catch (InstantiationException e) {
            throw new UnsupportedOperationException("Erro ao instanciar a estratégia para leitura do arquivo de retorno", e);
        }
    }

    /**
     * Descobre o nome do banco ao qual está vinculado um dado arquivo de retorno de boleto.
     * @param caminhoArquivo caminho completo do arquivo de retorno de boletos bancários de um determinado banco,
     *                       cujo nome do banco deve estar dentro do nome do arquivo.
     * @return nome do banco extraído do nome do arquivo (como Bradesco, BancoBrasil, etc).
     */
    private static String getNomeBanco(final String caminhoArquivo) {
        /* Define uma expressão regular para verificar se o nome do arquivo
         * segue o padrão esperado, sendo Nome-Banco-NumeroArquivo.csv.
         * Explicar expressões regulares está fora do escopo deste projeto.*/
        final Pattern regexPattern = Pattern.compile("(.+)-.+\\.csv");

        //Obtém apenas o nome do arquivo, sem a pasta
        String nomeArquivo = new File(caminhoArquivo).getName();

        //Cria um objeto Matcher para verificar se o nome do arquivo corresponde ao padrão
        //definido na expressão regular da variável regexPattern acima.
        final Matcher matcher = regexPattern.matcher(nomeArquivo);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Nome do arquivo não está no formado Nome-Banco-NumeroArquivo.csv");
        }

        /*
        Converte o nome do banco para Camel Case (iniciais de cada letra em maiúscula,
        como se espera que o nome de uma classe seja).
        WordUtils vem da biblioteca apache commons-text que foi adicionada ao pom.xml

        Como a expressão regular inclui um grupo de captura definido pelos parêntese
        em regexPattern, para obter apenas o conteúdo do nome do arquivo
        que corresponde ao padrão dentro de tais parênteses (que é o nome do banco),
        usamos matcher.group(1), pois matcher.group(0) obtém toda a String que
        corresponde ao padrão inteiro definido pela expressão regular.
        */
        final String nomeBanco = WordUtils.capitalizeFully(matcher.group(1), '-', ' ', '_');

        /*Remove separadores hífen, underline e espaço do nome da classe,
        pois classes em Java não devem ter tais caracteres ou mesmo não suportam.*/
        return nomeBanco.replaceAll("[-_ ]", "");
    }
}

