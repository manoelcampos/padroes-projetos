package com.manoelcampos.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Gerencia as configurações gerais do sistema. Observe que a classe não possui atributos.
 * Os getters e setters existentes utilizam a classe {@link Properties}
 * para obter/alterar cada configuração diretamente do/no arquivo.
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
     * Objeto que permite ler as configurações diretamente do arquivo indicado
     * em {@link #NOME_ARQUIVO}.
     */
    private Properties properties;

    /**
     * Instancia o objeto de configurações, carregando os dados
     * do arquivo {@link #NOME_ARQUIVO}.
     */
    public Config(){
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
        return Boolean.parseBoolean(
                properties.getProperty("exibirTotalUsuariosOnline"));
    }

    public void setExibirTotalUsuariosOnline(boolean exibirTotalUsuariosOnline) {
        properties.setProperty("exibirTotalUsuariosOnline",
                Boolean.toString(exibirTotalUsuariosOnline));
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
