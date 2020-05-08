import com.manoelcampos.util.Config;

import java.util.Scanner;

/**
 * Uma aplicação de exemplo que mostra como definir configurações
 * de um sistema por meio de um arquivo config.properties.
 * As configurações são gerenciadas pela classe {@link Config}.
 *
 * <p>Neste exemplo, é utilizado o padrão Singleton para resolver
 * os problemas apresentados no projeto "arquivo-configuracoes-problematico".
 * Veja a classe {@link Config} para mais detalhes.</p>
 *
 * <p>Observe que ao acessar a opção 1 no menu principal para exibir os relatórios,
 * se a sub-opção 4 for escolhida para alterar uma configuração como "Formato Padrão dos Relatórios",
 * ao voltar para a "tela" de relatórios, você já verá que tal configuração foi atualizada.</p>
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
