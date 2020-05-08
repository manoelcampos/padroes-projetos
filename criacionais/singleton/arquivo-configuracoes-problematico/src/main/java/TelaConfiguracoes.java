import com.manoelcampos.util.Config;

import java.util.Scanner;

/**
 * "Tela" para exibição e alteração de configurações do sistema.
 *
 * @author Manoel Campos da Silva Filho
 */
public class TelaConfiguracoes {
    private Config config = new Config();
    private Scanner teclado = new Scanner(System.in);

    public void exibir(){
        int opcaoMenu;
        do{
            System.out.println();
            System.out.println("1 - Formato Padrão dos Relatórios: " + config.getFormatoPadraoRelatorios());
            System.out.println("2 - Tipo Padrão Gráficos: " + config.getTipoPadraoGraficos());
            System.out.println("3 - Exibir Total Usuarios Online: " + config.isExibirTotalUsuariosOnline());
            System.out.println("4 - Exibir Data Hora Último Acesso: " + config.isExibirDataHoraUltimoAcesso());
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opção): ");
            opcaoMenu = Integer.parseInt(teclado.nextLine());
            alterarConfiguracao(opcaoMenu);
        } while(opcaoMenu != 0);

        //Salva as configurações no arquivo ao sair da tela.
        config.save();
    }

    /**
     * Altera uma determinada configuração, de acordo
     * com a opção escolhida pelo usuário no menu
     * @param opcaoMenu opção que o usuário escolheu no menu
     * @see #exibir()
     */
    private void alterarConfiguracao(int opcaoMenu) {
        switch (opcaoMenu){
            case 1:
                System.out.print("Digite o Formato Padrão dos Relatórios: ");
                config.setFormatoPadraoRelatorios(teclado.nextLine());
            break;
            case 2:
                System.out.print("Digite o Tipo Padrão Gráficos: ");
                config.setTipoPadraoGraficos(teclado.nextLine());
            break;
            case 3:
                System.out.print("Exibir Total Usuarios Online (S ou N): ");
                config.setExibirTotalUsuariosOnline(teclado.next().equalsIgnoreCase("S"));
            break;
            case 4:
                System.out.print("Exibir Data Hora Último Acesso (S ou N): ");
                config.setExibirDataHoraUltimoAcesso(teclado.next().equalsIgnoreCase("S"));
            break;
        }
    }
}
