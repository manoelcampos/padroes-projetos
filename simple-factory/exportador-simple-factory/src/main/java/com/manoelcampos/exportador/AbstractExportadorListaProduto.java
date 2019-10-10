package com.manoelcampos.exportador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {
    private List<Produto> produtos;
    protected static final List<String> TITULOS_COLUNAS = Arrays.asList("ID", "Descrição", "Marca", "Modelo", "Estoque");

    @Override
    public String exportar(List<Produto> produtos) {
        this.produtos = produtos;
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());

        gerarColunasLinha(sb, TITULOS_COLUNAS);
        sb.append(fecharLinhaTitulos());
        gerarLinhasProdutos(sb);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private void gerarLinhasProdutos(StringBuilder sb) {
        for (Produto produto : produtos) {
            List<String> valoresCamposProduto = new ArrayList<>();
            valoresCamposProduto.add(String.valueOf(produto.getId()));
            valoresCamposProduto.add(produto.getDescricao());
            valoresCamposProduto.add(produto.getMarca());
            valoresCamposProduto.add(produto.getModelo());
            valoresCamposProduto.add(String.valueOf(produto.getEstoque()));
            gerarColunasLinha(sb, valoresCamposProduto);
        }
    }

    private void gerarColunasLinha(StringBuilder sb, List<String> valores) {
        sb.append(abrirLinha());
        for (String valor : valores) {
            sb.append(abrirColuna(valor))
              .append(fecharColuna());
        }
        sb.append(fecharLinha());
    }
}
