/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class ExibirInfos extends Application{
    @FXML
    HBox hbox = new HBox();
    @FXML
    VBox vbox, hbox2, hbox3 ;
    ArrayList<HBox> listaItens = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        
//        hbox = FXMLLoader.load(getClass().getResource("/view/hbox.fxml"));
//
//        
//        vbox.getChildren().add(hbox);
//        vbox.getChildren().add(hbox2);
//        primaryStage.setScene(new Scene( vbox));
//        primaryStage.show();
    }
   
}
