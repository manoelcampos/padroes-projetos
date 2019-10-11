import com.manoelcampos.exportador.ExportadorListaProduto;
import com.manoelcampos.exportador.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Executa a aplicação para exibir os resultados.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "TV", "LG", "132-A", 120));
        produtos.add(new Produto(2, "Notebook", "Asus", "New age", 341));
        produtos.add(new Produto(3, "Smartphone", "Samsung", "Galaxy S10", 214));

        ExportadorListaProduto exportador = ExportadorListaProduto.getInstance();
        System.out.println(exportador.exportar(produtos));
    }
}
