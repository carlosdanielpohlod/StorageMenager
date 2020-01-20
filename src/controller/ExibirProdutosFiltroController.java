/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDBDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Produto;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class ExibirProdutosFiltroController implements Initializable {
 @FXML
     private TableView tabela = new TableView<>();
    @FXML
        TableColumn colunaNome = new TableColumn<>("Nome");
    TableColumn colBotao = new TableColumn<Produto, Button>("Botao");
    @FXML
        TableColumn colunaQuantidade = new TableColumn<>("Quantidade");
    @FXML
        TableColumn colunaDescricao = new TableColumn<>("Descricao");
    @FXML 
        TableColumn colunaIcon = new TableColumn <Produto,ImageView>("Visualizar");
    @FXML
        TableColumn selectCol = new TableColumn<>("Selecioanar");
    @FXML
    private TableColumn colValorUnitario = new TableColumn<>("ValorUnitario");
    Label lblVisualizar;
    @FXML
    private Button btnVisualizar;
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    private AnchorPane center;
    private BorderPane root;
    private Button b = new Button("AÇÃO");
    private ProdutoDBDAO dbdao = new ProdutoDBDAO ();
    public static Produto produto;
    @FXML
    private Button btnCadastrarProduto;
    @FXML
    private TextField tfdPesquisar;
    @FXML
    private Button btnPesquisar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaIcon.setCellValueFactory(new PropertyValueFactory<>("icon"));
        colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        
        
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));
        tabela.setItems(FXCollections.observableArrayList(ExibirProdutosController.produtosFiltro));
        tabela.getColumns().addAll(colunaNome, colunaQuantidade, colunaDescricao,colunaIcon,colValorUnitario, selectCol); 
    }    

    @FXML
    private void btnVisualizarOnAction(ActionEvent event) {
    }

    @FXML
    private void btnCadastrarProdutoOnAction(ActionEvent event) {
    }

    @FXML
    private void btnPesquisarOnAction(ActionEvent event) {
    }
    
}
