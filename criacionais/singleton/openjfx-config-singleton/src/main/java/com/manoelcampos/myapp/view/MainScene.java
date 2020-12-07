package com.manoelcampos.myapp.view;

import com.manoelcampos.myapp.App;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

/**
 * Cena (tela/view) principal da aplicação.
 * @author manoelcampos
 */
public class MainScene extends AbstractScene {

    public MainScene(App app) {
        super(app);
        var label = new Label("Hello, JavaFX ");
        var btnRelatorios = new Button("Relatórios");
        var btnConfig = new Button("Configurações");
        
        //Adiciona os campos na tela, organizando um após o outro (TilePane)
        setRoot(new TilePane(label, btnRelatorios, btnConfig));
        
        /*Quando o botão for clicado, exibe a cena de Relatórios.
        O código usa o recurso de Expressões Lambda introduzidas no Java 8.
        */
        btnRelatorios.setOnAction(event -> app.setScene(new RelatoriosScene(app)));

        /*Quando o botão for clicado, exibe a cena de Configurações.
        O código usa o recurso de Expressões Lambda introduzidas no Java 8.
        */
        btnConfig.setOnAction(event -> app.setScene(new ConfigScene(app)));
    }
    
}
