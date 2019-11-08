package com.manoelcampos.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Gerencia as configurações gerais do sistema.
 * Esta implementação aplica o padrão Singleton para permitir
 * criar uma única instância da classe Config em toda a aplicação.
 * Com isto, mesmo que declararemos diversas variáveis
 * para tal classe, elas serão apenas uma referência para este único objeto criado.
 * Se alterarmos uma configuração em qualquer das "telas" do sistema,
 * as variáveis config declaradas em qualquer lugar estarão apontando
 * para o mesmo objeto. Portanto, estaremos acessando os dados sempre atualizados.
 * Não teremos mais problemas de em uma tela ser exibido o valor atual de
 * uma configuração, enquanto em outra ainda é exibido um valor desatualizado.
 *
 * <p>Observe que a classe não possui atributos.
 * Os getters e setters existentes utilizam a classe {@link Properties}
 * para obter/alterar cada configuração diretamente do/no arquivo.</p>
 *
 * <p>Poderíamos não ter esta classe e utilizarmos diretamente a classe
 * {@link Properties} em todos os locais
 * onde precisarmos gerenciar configurações do sistema.
 * No entanto, isso vai fazer com que tenhamos os nomes de cada
 * configuração espalhados pelo sistema.
 * Se um nome de uma configuração fosse alterado,
 * teríamos que procurar os locais onde ela estava sendo
 * usada e alterar, o que pode nem sempre ser fácil de localizar
 * ou podemos simplesmente esquecer de procurar.</p>
 *
 * <p>Adicionalmente, como o arquivo properties armazena apenas texto,
 * esta classe se encarrega de fazer as conversões necessárias
 * quando temos configurações com um tipo específico como int, boolean, etc.
 * Veja que métodos como {@link #isExibirTotalUsuariosOnline()} faz a conversão
 * de String para boolean.
 * </p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Config {
    private static final String NOME_ARQUIVO = "config.properties";

    /**
     * Atributo estático que representa a única instância a ser criada
     * para esta classe. No padrão Singleton, a classe possui um atributo estático e privado do tipo dela mesma.
     * Por isso nossa classe Config possui um atributo do tipo Config.
     */
    private static Config instance;

    /**
     * Objeto que permite ler as configurações diretamente do arquivo indicado
     * em {@link #NOME_ARQUIVO}.
     */
    private Properties properties;

    /**
     * Método que retorna uma instância previamente criada
     * ou uma nova instância caso nenhum tenha sido criada ainda.
     * Observe que diferente do padrão Factory Method
     * que o nome do método normalmente é newInstance (pois ele sempre
     * cria uma nova instância), no padrão Singleton,
     * tal método é chamado de getInstance, pois ele vai retornar:
     * <ul>
     * <li>uma instância já existente;</li>
     * <li>ou uma nova instância uma caso nenhuma tenha sido criada ainda.</li>
     * </ul>
     *
     * @return
     */
    public static final Config getInstance(){
        if(instance == null){
            instance = new Config();
        }

        return instance;
    }

    /**
     * Define um construtor privado para impedir que a classe
     * seja instanciada diretamente.
     */
    private Config(){
        properties = new Properties();
        try {
            properties.load(Files.newInputStream(getCaminhoArquivo()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Obtém o caminho do arquivo de configurações, considerando que o mesmo está na raiz da pasta resources.
     * O getClass().getClassLoader() é usado para permitir obter o caminho do arquivo
     * na raiz de tal pasta.
     * Usando somente getClass(), o arquivo deveria estar em uma pasta com o mesmo
     * caminho do pacote onde a classe atual está (ou seja, resources/com/manoelcampos/configuracoes).
     */
    private Path getCaminhoArquivo() {
        return Paths.get(getClass().getClassLoader().getResource(NOME_ARQUIVO).getPath());
    }

    public String getFormatoPadraoRelatorios() {
        return properties.getProperty("formatoPadraoRelatorios");
    }

    public void setFormatoPadraoRelatorios(String formatoPadraoRelatorios) {
        properties.setProperty("formatoPadraoRelatorios", formatoPadraoRelatorios);
    }

    public String getTipoPadraoGraficos() {
        return properties.getProperty("tipoPadraoGraficos");
    }

    public void setTipoPadraoGraficos(String tipoPadraoGraficos) {
        properties.setProperty("tipoPadraoGraficos", tipoPadraoGraficos);
    }

    public boolean isExibirTotalUsuariosOnline() {
        return Boolean.parseBoolean(properties.getProperty("exibirTotalUsuariosOnline"));
    }

    public void setExibirTotalUsuariosOnline(boolean exibirTotalUsuariosOnline) {
        properties.setProperty("exibirTotalUsuariosOnline", Boolean.toString(exibirTotalUsuariosOnline));
    }

    public boolean isExibirDataHoraUltimoAcesso() {
        return Boolean.parseBoolean(properties.getProperty("exibirDataHoraUltimoAcesso"));
    }

    public void setExibirDataHoraUltimoAcesso(boolean exibirDataHoraUltimoAcesso) {
        properties.setProperty("exibirTotalUsuariosOnline", Boolean.toString(exibirDataHoraUltimoAcesso));
    }

    /**
     * Salva as configurações no arquivo {@link #NOME_ARQUIVO}.
     */
    public void save(){
        try {
            properties.store(Files.newOutputStream(getCaminhoArquivo()), "configurações do sistema");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
