package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe abstrata que fornece uma implementação base para as subclasses
 * que definem formatos específicos de exportação de dados.
 *
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractExportadorLista implements ExportadorLista {
    /**
     * Lista de objetos a serem exportados para um formato definido pelas subclasses.
     * Observe que o tipo não é {@code List<Object>},
     * mas {@code List<?>}.
     * Usando o primeiro tipo, não poderíamos passar uma {@code List<Cliente>} ou {@code List<Produto>}.
     * Teríamos que passar exatamente uma {@code List<Object>}.
     * Como dissemos que a lista a ser recebida pode conter qualquer tipo
     * (representando pela interrogação), podemos passar uma lista de qualquer coisa.
     * Para isto, estamos usando um dos recursos de Generics do Java.
     * Podemos identificar o uso de Generics pela presença dos sinais {@code < e >}
     * depois de um tipo qualquer como List.
     */
    private List<?> lista;

    /**
     * Colunas a serem exibidas na tabela gerada no processo de exportação.
     * Elas representam os nomes dos atributos dos objetos contidos na {@link #lista}.
     */
    private List<String> nomesCampos;

    @Override
    public String exportar(List<?> lista) {
        Objects.requireNonNull(lista);
        if(lista.isEmpty()){
            throw new IllegalArgumentException("A lista fornecida está vazia");
        }

        this.lista = lista;
        this.nomesCampos = gerarTitulosColunas();

        final var sb = new StringBuilder();
        sb.append(abrirTabela())
          .append(gerarColunasLinha(nomesCampos))
          .append(fecharLinhaTitulos())
          .append(gerarLinhasObjetos())
          .append(fecharTabela());
        return sb.toString();
    }

    /**
     * Descobre dinamicamente os nomes das colunas dos objetos contindos na {@link #lista}
     * a ser exportada. Diferentes objetos têm atributos distintos.
     * Uma vez que podemos exportar listas de qualquer tipo de objetos,
     * o método utiliza o recurso de Reflection do Java
     * para descobrir quais são os atributos dos objetos da lista que deseja-se exportar.
     *
     * @return
     */
    private List<String> gerarTitulosColunas() {
        /*Pega o primeiro objeto da lista para podermos descobrir o nome dos atributos dele.
        Se a lista estiver vazia, já será gerada uma exceção anteriormente.*/
        Object objeto = lista.get(0);

        List<String> titulosColunas = new ArrayList<>();

        //Obtém o nome dos campos (fields) declarados diretamente na classe do objeto.
        Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            //Atributos estáticos não serão incluídos na tabela gerada
            if(!Modifier.isStatic(campo.getModifiers())) {
                titulosColunas.add(campo.getName());
            }
        }

        return titulosColunas;
    }
    /**
     * Gera o texto representando todas as linhas de uma tabela (em um formato definido pelas subclasses)
     * contendo os dados dos objetos na {@link #lista}.
     *
     * @return {@link StringBuilder} com o texto gerado
     */
    private StringBuilder gerarLinhasObjetos() {
        final var sb = new StringBuilder();
        for (Object objeto : lista) {
            sb.append(gerarLinhaObjeto(objeto));
        }

        return sb;
    }

    /**
     * Gera o texto representando uma única linha de uma tabela (em um formato definido pelas subclasses)
     * contendo os dados de um objeto na {@link #lista}.
     *
     * @param objeto objeto contendo os valores a serem exibidos nas colunas da linha sendo gerada
     * @return {@link StringBuilder} com o texto gerado
     */
    private StringBuilder gerarLinhaObjeto(Object objeto) {
        final var sb = new StringBuilder();
        List<String> valoresCamposObjeto = new ArrayList<>();
        //O loop apenas obtém o valor de cada atributo do objeto passado e gera uma lista com tais valores
        for (String campo : nomesCampos) {
            String valorCampo = getValorCampoObjeto(objeto, campo);
            valoresCamposObjeto.add(String.valueOf(String.valueOf(valorCampo)));
        }

        //Com a lista de valores dos atributos do objeto, geramos uma linha da tabela
        sb.append(gerarColunasLinha(valoresCamposObjeto));
        return sb;
    }

    /**
     * Obtém o valor de um determinado campo de um objeto da {@link #lista} como String.
     *
     * @param objeto objeto de onde o valor de um determinado campo será obtido
     * @param nomeCampo nome do campo (atributo/field) que deseja-se obter o valor
     * @return o valor do campo como String ou vazio se o campo for null
     */
    private String getValorCampoObjeto(Object objeto, String nomeCampo) {
        Object valorCampo;
        try {
            Field campo = objeto.getClass().getDeclaredField(nomeCampo);
            campo.setAccessible(true);
            valorCampo = campo.get(objeto);

            return valorCampo == null ? "" : String.valueOf(valorCampo);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gera o texto representando uma única linha de uma tabela (em um formato definido pelas subclasses).
     *
     * @param valores valores a serem exibidos nas colunas, que podem ser:
     *                (i) os títulos das colunas (caso esteja sendo gerada a linha de cabeçalho da tabela) ou
     *                (ii) os valores de uma linha da tabela (caso esteja sendo gerado uma linha de conteúdo da tabela).
     *                Neste último caso, tal parâmetro deve conter os valores dos atributos de um objeto da {@link #lista}.
     * @return {@link StringBuilder} contendo o texto gerado
     */
    private StringBuilder gerarColunasLinha(List<String> valores) {
        final var sb = new StringBuilder();
        sb.append(abrirLinha());
        for (String valor : valores) {
            sb.append(abrirColuna(valor))
              .append(fecharColuna());
        }
        sb.append(fecharLinha());
        return sb;
    }

    @Override
    public List<String> getNomesCampos() {
        return nomesCampos;
    }
}
