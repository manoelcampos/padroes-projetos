import com.manoelcampos.util.Config;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Uma aplicação de exemplo que mostra como definir configurações
 * de um sistema por meio de um arquivo config.properties.
 * As configurações são gerenciadas pela classe {@link Config}.
 *
 * <p>Para reproduzir o problema:
 *
 * - Escolha a opção 1-Relatórios do menu principal
 * - Escolha a sub-opção 4-Configurações
 * - Altere uma configuração como o Formato dos Relatórios
 * - Ao voltar para a tela anterior, tal configuração não é atualizada,
 * mesmo que tenhamos salvo as alterações no arquivo de configurações
 * antes de sair da respectiva tela.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    private Scanner teclado = new Scanner(System.in);

    public void exibir(){
        int opcaoMenu;
        do{
            System.out.println("\n----------- Menu Principal -----------");
            System.out.println("1 - Relatórios");
            System.out.println("2 - Gráficos");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcaoMenu = Integer.parseInt(teclado.nextLine());
            System.out.println();
            switch(opcaoMenu){
                case 1: new TelaRelatorios().exibir(); break;
                case 2: System.out.println("Tela de gráficos não disponível"); break;
            }
        }while(opcaoMenu != 0);
    }

    public static void main(String[] args) {
        new Principal().exibir();
    }
}
