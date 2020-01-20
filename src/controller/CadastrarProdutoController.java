/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDBDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import model.Produto;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class CadastrarProdutoController implements Initializable {

    @FXML
    private TextField tfdTitulo;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private ImageView imgFoto;
    @FXML
    private Button btnVoltar;
    @FXML
    private TextField tfdTamanho,tfdPreco;
    private Produto produto = new Produto();
    @FXML
    private ObservableList<String> categoria = FXCollections.observableArrayList("sapatilha","sapatopreto");
     @FXML
       private  ChoiceBox choiceCategoria = new ChoiceBox();
     @FXML
        private Spinner spinnerQuantidade = new Spinner();
     private ProdutoDBDAO dbdao = new ProdutoDBDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       choiceCategoria.getItems().addAll("Calçado","Mochila","Roupa");
       choiceCategoria.setTooltip(new Tooltip("aaa"));
       SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 0);
 
        spinnerQuantidade.setValueFactory(valueFactory);
    }  

    @FXML
    private void btnVoltarOnAction(ActionEvent event) {
        
    }
    @FXML
    private void btnContinuarOnAction(ActionEvent event){
        switch((String)choiceCategoria.getValue()){
            case "Calçado" : produto.setIdTipoProduto(1);
                break;
            case "Mochila" : produto.setIdTipoProduto(2);
                break;
            case "Roupa" : produto.setIdTipoProduto(3);
                break;
        }
        produto.setQuantidade((int)spinnerQuantidade.getValue());
        produto.setNome(tfdTitulo.getText());
        produto.setDescricao(txtDescricao.getText());
        produto.setTamanhoProduto(tfdTamanho.getText());
        double cast = Double.parseDouble(tfdPreco.getText());
        produto.setValorUnitario(cast);
        try {
            dbdao.cadastraProduto(produto);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        System.out.println("IdProduto"+ produto.getIdTipoProduto());
        System.out.println("quantidade"+ produto.getQuantidade());
    }
}
