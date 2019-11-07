import com.manoelcampos.util.Config;

import java.util.Scanner;

/**
 * "Tela" de impressão de relatórios,
 * utilizando as configurações definidas em {@link Config}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class TelaRelatorios {
    private Config config = Config.getInstance();
    private Scanner teclado = new Scanner(System.in);

    public void exibir(){
        int opcaoMenu;
        do{
            System.out.println();
            System.out.println("Gerando relatórios em formato " + config.getFormatoPadraoRelatorios());
            System.out.println("1 - Relatório de Vendas");
            System.out.println("2 - Relatório de Estoque");
            System.out.println("3 - Relatório de Clientes");
            System.out.println("4 - Configurações");
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opção: ");
            opcaoMenu = Integer.parseInt(teclado.nextLine());
            switch (opcaoMenu){
                case 1: System.out.println("Imprimindo Relatório de Vendas"); break;
                case 2: System.out.println("Imprimindo Relatório de Estoque"); break;
                case 3: System.out.println("Imprimindo Relatório de Clientes"); break;
                case 4: new TelaConfiguracoes().exibir(); break;
            }
        } while(opcaoMenu != 0);
    }
}
