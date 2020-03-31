package com.manoelcampos.exportador;

import java.util.Arrays;
import java.util.List;

/**
 * Classe abstrata que fornece uma implementação base para as subclasses
 * que definem formatos específicos de exportação de dados.
 *
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    /**
     * Colunas a serem exibidas na tabela gerada no processo de exportação.
     */
    protected static final List<String> TITULOS_COLUNAS = Arrays.asList("ID", "Descrição", "Marca", "Modelo", "Estoque");

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());

        sb.append(gerarColunasLinha(TITULOS_COLUNAS));
        sb.append(fecharLinhaTitulos());
        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());
        return sb.toString();
    }

    /**
     * Gera o texto representando todas as linhas de uma tabela (em um formato definido pelas subclasses)
     * contendo os dados dos produtos na lista de produtos.
     *
     * @param sb {@link StringBuilder} onde o texto gerado será adicionado
     * @param listaProdutos
     */
    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            List<String> valoresCamposProduto =
                    Arrays.asList(String.valueOf(produto.getId()),
                                  produto.getDescricao(),
                                  produto.getMarca(),
                                  produto.getModelo(),
                                  String.valueOf(produto.getEstoque()));
            sb.append(gerarColunasLinha(valoresCamposProduto));
        }
    }

    /**
     * Gera o texto representando uma única linha de uma tabela (em um formato definido pelas subclasses).
     *
     * @param valores valores a serem exibidos nas colunas, que podem ser:
     *                (i) os títulos das colunas (caso esteja sendo gerada a linha de cabeçalho da tabela) ou
     *                (ii) os valores de uma linha da tabela (caso esteja sendo gerado uma linha de conteúdo da tabela).
     *                Neste último caso, tal parâmetro deve conter os valores dos atributos de um objeto da lista de produtos.
     * @return uma String representando a linha gerada com os valores
     */
    protected String gerarColunasLinha(List<String> valores) {
        StringBuilder sb = new StringBuilder();
        sb.append(abrirLinha());
        for (String valor : valores) {
            sb.append(abrirColuna(valor))
              .append(fecharColuna());
        }
        sb.append(fecharLinha());
        return sb.toString();
    }
}
