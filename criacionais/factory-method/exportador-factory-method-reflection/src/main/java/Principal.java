import com.manoelcampos.exportador.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    private static final List<Usuario> USUARIOS = Arrays.asList(
            new Usuario("Manoel Campos da Silva Filho", "123.456.789-01", "Palmas"),
            new Usuario("Joana Brito", "444.555.666-77", "Porto Nacional"),
            new Usuario("Lúcia Alves", "999.888.777-66", "Palmas")
    );

    private static final List<Produto> PRODUTOS = Arrays.asList(
            new Produto("TV", "LG", "132-A", 120),
            new Produto("Notebook", "Asus", "New age", 341),
            new Produto("Smartphone", "Samsung", "Galaxy S10", 214)
    );

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.exportarUsuarios();
        principal.exportarProdutos();
    }

    private void exportarUsuarios() {
        //Usa o método getInstance() para instanciar um exportador padrão (neste caso, que gera HTML)
        final ExportadorLista<Usuario> exportadorPadrao = ExportadorLista.newInstance(USUARIOS);

        /* Este método newColuna é que representa a implementação do padrão Factory Method.
        * Veja a documentação dele para mais detalhes */
        Coluna<Usuario> coluna = exportadorPadrao.newColuna(this::getSobrenomeUsuario, "Sobrenome");

        exportadorPadrao.addColuna(coluna);

        System.out.println("Lista de Usuários em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar());

        //Usa a outra versão do método getInstance() para instanciar um exportador específico para o formato Markdown (md)
        final ExportadorLista<Usuario> exportadorMarkdown = ExportadorLista.newInstance(USUARIOS, "md");

        coluna = exportadorMarkdown.newColuna(this::getSobrenomeUsuario, "Sobrenome");
        exportadorMarkdown.addColuna(coluna);

        System.out.println("Lista de Usuários em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar());
    }

    /**
     * Usa "Expressões Regulares" para extrair o sobrenome do usuário,
     * considerando que a classe usuário não possui um método para isso
     * e que não podemos alterar tal classe.
     * Por exemplo, digamos que não temos acesso ao código fonte dela.
     *
     * @param usuario usuário para obter o sobrenome
     * @return sobrenome do usuário ou vazio se não existir
     */
    private String getSobrenomeUsuario(Usuario usuario){
        Pattern regexPattern = Pattern.compile(".+?\\s(.*)");
        Matcher matcher = regexPattern.matcher(usuario.getNome());
        return matcher.matches() ? matcher.group(1) : "";
    }

    private void exportarProdutos() {
        final ExportadorLista<Produto> exportadorPadrao = ExportadorLista.newInstance(PRODUTOS);
        System.out.println("Lista de Produtos em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar());

        final ExportadorLista<Produto> exportadorMarkdown = ExportadorLista.newInstance(PRODUTOS, "md");
        System.out.println("Lista de Produtos em Markdown------------------------------------------------------\n");
        System.out.println(exportadorMarkdown.exportar());
    }
}
