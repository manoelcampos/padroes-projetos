package com.manoelcampos.myapp.view;

import com.manoelcampos.myapp.App;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;

/**
 * Classe abstrata que representa uma cena (tela/view).
 * 
 * @author manoelcampos
 */
public abstract class AbstractScene extends Scene{
    /**
     * Instância da aplicação, que permite por exemplo,
     * a alternância entre cenas (telas/views).
     */
    private final App app;
    
    public AbstractScene(App app){
        /*Cria uma cena com uma determinada dimensão de tela
        e organizando os futuros componentes, por padrão,
        um do lado do outro (TilePane)*/
        super(new TilePane(), 640, 480);
        
        this.app = app;
    }
    
    public App getApp(){
        return app;
    }     
    
}
