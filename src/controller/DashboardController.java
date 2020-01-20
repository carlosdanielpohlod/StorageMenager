/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class DashboardController implements Initializable {

    private App app = new App();
    @FXML
    private Button btnGerenciarEstoque;
    @FXML
    private AnchorPane  center = new AnchorPane();
    private BorderPane root = new BorderPane();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnGerenciarEstoqueOnAction(ActionEvent event) throws IOException {
        center = FXMLLoader.load(getClass().getResource("/view/ExibirProdutos.fxml"));
        root = app.getRoot();
        root.setCenter(center);
        
    }
    
}
