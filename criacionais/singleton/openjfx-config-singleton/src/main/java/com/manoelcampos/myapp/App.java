package com.manoelcampos.myapp;

import com.manoelcampos.myapp.view.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Aplicação JavaFX. Esta é a classe principal que inicia a aplicação.
 */
public class App extends Application {
    /**
     * Stage é o palco, a janela onde as cenas (telas/views) aparecem.
     * Neste exemplo, existe apenas uma janela
     * e apenas são trocadas as cenas a serem exibidas.
     * 
     * Temos a cena principal {@link MainScene},
     * a de relatórios {@link RelatoriosScene}
     * e a de configurações {@link ConfigScene}.
     */
    private Stage stage;

    /**
     * Inicia a primeira cena (tela/view)
     * @param stage palco principal onde as cenas serão exibidas.
     */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setScene(new MainScene(this));
        stage.show();
    }

    /**
     * Inicia a aplicação.
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }
    
    /**
     * Troca a cena (tela/view) em exibição.
     * @param scene cena que será exibida
     */
    public void setScene(Scene scene){
        stage.setScene(scene);
    }
    
}