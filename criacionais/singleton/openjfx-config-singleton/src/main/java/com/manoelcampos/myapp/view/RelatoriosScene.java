package com.manoelcampos.myapp.view;

import com.manoelcampos.myapp.App;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

/**
 * Cena (tela/view) para exibição de relatórios.
 * @author manoelcampos
 */
public class RelatoriosScene extends AbstractScene {

    public RelatoriosScene(App app) {
        super(app);
        
        //TODO: EXIBIR CONFIGURAÇÃO DENTRO DO LABEL
        var label = new Label("Formato Relatórios: ");
        var btnVoltar = new Button("Voltar");
        
        //Adiciona os campos na tela, organizando um após o outro (TilePane)
        setRoot(new TilePane(label, btnVoltar));
        
        /*Quando o botão for clicado, instancia e mostra 
        a tela principal novamente. 
        O código usa o recurso de Expressões Lambda introduzidas no Java 8.
        */
        btnVoltar.setOnAction(event -> app.setScene(new MainScene(app)));
    }
    
}
