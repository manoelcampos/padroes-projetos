import com.manoelcampos.exportador.Cliente;
import com.manoelcampos.exportador.ExportadorLista;
import com.manoelcampos.exportador.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Manoel", "123.456.789-01", "Palmas"));
        clientes.add(new Cliente(2, "Joana", "444.555.666-77", "Porto Nacional"));
        clientes.add(new Cliente(3, "Lúcia", "999.888.777-66", "Palmas"));

        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "TV", "LG", "132-A", 120));
        produtos.add(new Produto(2, "Notebook", "Asus", "New age", 341));
        produtos.add(new Produto(3, "Smartphone", "Samsung", "Galaxy S10", 214));

        //Usa o método getInstance() para instanciar um exportador padrão (neste caso, que gera HTML)
        final ExportadorLista exportadorPadrao = ExportadorLista.getInstance();
        System.out.println("Lista de Clientes em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(clientes));

        System.out.println("Lista de Produtos em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(produtos));

        //Usa a outra versão do método getInstance() para instanciar um exportador específico para o formato Markdown (md)
        final ExportadorLista exportadorMarkdown = ExportadorLista.getInstance("md");
        System.out.println("Lista de Clientes em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar(clientes));

        System.out.println("Lista de Produtos em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar(produtos));

    }
}
