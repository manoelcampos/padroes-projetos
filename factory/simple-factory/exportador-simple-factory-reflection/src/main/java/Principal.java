import com.manoelcampos.exportador.Usuario;
import com.manoelcampos.exportador.ExportadorLista;
import com.manoelcampos.exportador.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Manoel", "123.456.789-01", "Palmas"));
        usuarios.add(new Usuario("Joana", "444.555.666-77", "Porto Nacional"));
        usuarios.add(new Usuario("Lúcia", "999.888.777-66", "Palmas"));

        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("TV", "LG", "132-A", 120));
        produtos.add(new Produto("Notebook", "Asus", "New age", 341));
        produtos.add(new Produto("Smartphone", "Samsung", "Galaxy S10", 214));

        //Usa o método getInstance() para instanciar um exportador padrão (neste caso, que gera HTML)
        final ExportadorLista exportadorPadrao = ExportadorLista.newInstance();
        System.out.println("Lista de Usuários em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(usuarios));

        System.out.println("Lista de Produtos em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(produtos));

        //Usa a outra versão do método getInstance() para instanciar um exportador específico para o formato Markdown (md)
        final ExportadorLista exportadorMarkdown = ExportadorLista.newInstance("md");
        System.out.println("Lista de Usuários em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar(usuarios));

        System.out.println("Lista de Produtos em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar(produtos));

    }
}
