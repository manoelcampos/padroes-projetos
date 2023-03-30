import com.manoelcampos.exportador.ExportadorListaProduto;
import com.manoelcampos.exportador.Produto;

import java.util.List;

/**
 * Executa a aplicação Exportador Simple Factory.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final var listaProdutos = List.of(
            new Produto("TV", "LG", "132-A", 120),
            new Produto("Notebook", "Asus", "New age", 341),
            new Produto("Smartphone", "Samsung", "Galaxy S10", 214)
        );

        final var exportadorPadrao = ExportadorListaProduto.newInstance();
        System.out.println("Lista de Produtos em HTML\n");
        System.out.println(exportadorPadrao.exportar(listaProdutos));

        final var exportadorMarkdown = ExportadorListaProduto.newInstance("md");
        System.out.println("Lista de Produtos em Markdown\n");
        System.out.println(exportadorMarkdown.exportar(listaProdutos));
    }
}
