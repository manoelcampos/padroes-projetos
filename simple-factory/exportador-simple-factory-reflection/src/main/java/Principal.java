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


        ExportadorLista exportador = ExportadorLista.getInstance();
        System.out.println("Lista de Clientes\n");
        System.out.println(exportador.exportar(clientes));

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Lista de Produtos\n");
        System.out.println(exportador.exportar(produtos));
    }
}
