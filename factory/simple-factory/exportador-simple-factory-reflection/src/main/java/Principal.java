import com.manoelcampos.exportador.Usuario;
import com.manoelcampos.exportador.ExportadorLista;
import com.manoelcampos.exportador.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    private static final List<Usuario> USUARIOS = Arrays.asList(
            new Usuario("Manoel", "123.456.789-01", "Palmas"),
            new Usuario("Joana", "444.555.666-77", "Porto Nacional"),
            new Usuario("Lúcia", "999.888.777-66", "Palmas")
    );

    private static final List<Produto> PRODUTOS = Arrays.asList(
            new Produto("TV", "LG", "132-A", 120),
            new Produto("Notebook", "Asus", "New age", 341),
            new Produto("Smartphone", "Samsung", "Galaxy S10", 214)
    );

    public static void main(String[] args) {
        exportarUsuarios();
        exportarProdutos();
    }

    private static void exportarUsuarios() {
        //Usa o método getInstance() para instanciar um exportador padrão (neste caso, que gera HTML)
        final ExportadorLista exportadorPadrao = ExportadorLista.newInstance();
        System.out.println("Lista de Usuários em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(USUARIOS));

        //Usa a outra versão do método getInstance() para instanciar um exportador específico para o formato Markdown (md)
        final ExportadorLista exportadorMarkdown = ExportadorLista.newInstance("md");
        System.out.println("Lista de Usuários em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar(USUARIOS));
    }

    private static void exportarProdutos() {
        final ExportadorLista exportadorPadrao = ExportadorLista.newInstance();
        System.out.println("Lista de Produtos em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(PRODUTOS));

        final ExportadorLista exportadorMarkdown = ExportadorLista.newInstance("md");
        System.out.println("Lista de Produtos em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar(PRODUTOS));
    }
}
