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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private AnchorPane  center;
    private BorderPane root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnGerenciarEstoqueOnAction(ActionEvent event) throws IOException {
           root = new BorderPane();
       
          center = new AnchorPane();
          root = App.root;   
        try {
            center = FXMLLoader.load(getClass().getResource("/view/ExibirProdutos.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ExibirProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
          root.setCenter(center);
        
    }
    
}
