package com.manoelcampos.springboot.singleton.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Classe com configurações do sistema.
 * Para garantir que as mesmas configurações sejam visualizadas
 * em qualquer parte do sistema, mesmo que tenham sido alteradas
 * em algum lugar, está sendo usado o padrão Singleton
 * por meio da anotação {@link Scope} do Spring.
 *
 * <p>Esta anotação define o ciclo de vida e visibilidade de
 * um objeto injetado (instanciado automaticamente) pelo Spring.
 * Neste caso, usamos o escopo "singleton" para indicar
 * que deve existir apenas uma única instância da classe config
 * no sistema inteiro. Assim, mesmo que declararmos variáveis
 * config em diferentes locais, elas serão apenas referências para
 * um mesmo objeto em memória.</p>
 *
 * <p>A anotação Scope não é necessária aqui, pois
 * por padrão, abjetos injetados pelo Spring tem o escopo
 * singleton como padrão. Assim, a anotação foi incluída
 * apenas para deixar explícito que estamos usando singleton neste projeto.</p>
 *
 * <p>No entanto, para que o Spring consiga injetar automaticamente objetos Config
 * e gerenciar seu ciclo de vida, precisamos anotar a classe com @{@link Component}.</p>
 * @author Manoel Campos da Silva Filho
 */
@Getter @Setter @Component @Scope("singleton")
public class Config {
    private String extensaoFormatoRelatorio = "html";
    private TipoGrafico tipoGrafico = TipoGrafico.PIZZA;
}

