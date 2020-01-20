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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class DetalhesProdutoController implements Initializable {
    
      @FXML
    private AnchorPane center;
    @FXML
    private BorderPane root;
      @FXML
    private TextField tfdTitulo;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private ImageView imgFoto;
    @FXML
    private Image foto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgFoto.setImage(ExibirProdutosController.produto.getIconImage());
        tfdTitulo.setText(ExibirProdutosController.produto.getNome());
    }    
    @FXML
    public void btnVoltarOnAction(ActionEvent e) throws IOException{
        root = new BorderPane();
          center = new AnchorPane();
          root = App.root;   
          center = FXMLLoader.load(getClass().getResource("/view/ExibirProdutos.fxml"));
          root.setCenter(center);
    }
}
