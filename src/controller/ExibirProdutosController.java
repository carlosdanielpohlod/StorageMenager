/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import app.App;
import dao.ProdutoDBDAO;
import java.awt.event.ActionEvent;
import java.io.IOException;
import model.Produto;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class ExibirProdutosController implements Initializable {
    @FXML
        TableView tabela = new TableView<>();
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
        TableColumn colValorUnitario = new TableColumn<>("ValorUnitario");
    Label lblVisualizar;
    @FXML
        private Button btnVisualizar;
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    private AnchorPane center;
    private BorderPane root;
        Button b = new Button("AÇÃO");
    private ProdutoDBDAO dbdao = new ProdutoDBDAO ();
    public static Produto produto;
    @FXML
    private Button btnCadastrarProduto;
    @FXML
    private TextField tfdPesquisar;
    @FXML
    private Button btnPesquisar;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            dbdao.dowloadProdutos(produtos);
        } catch (SQLException ex) {
            System.out.println("Erro ao baxa");
        }
        
        
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaIcon.setCellValueFactory(new PropertyValueFactory<>("icon"));
        colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        
        
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));
        //colBotao.setCellFactory(new PropertyValueFactory<>("botao"));
       
        colunaNome.setCellFactory(TextFieldTableCell.forTableColumn());
        tabela.setItems(FXCollections.observableArrayList(produtos));
        tabela.getColumns().addAll(colunaNome, colunaQuantidade, colunaDescricao,colunaIcon,colValorUnitario, selectCol); 
        
    }
    @FXML
    private void btnVisualizarOnAction(javafx.event.ActionEvent event) throws IOException {
          produto = (Produto) tabela.getSelectionModel().getSelectedItem();
          root = new BorderPane();
       
          center = new AnchorPane();
          root = App.root;   
          center = FXMLLoader.load(getClass().getResource("/view/DetalhesProduto.fxml"));
          root.setCenter(center);
        
    }
 
    @FXML
    private void btnCadastrarProdutoOnAction(javafx.event.ActionEvent event) {
        root = new BorderPane();
       
          center = new AnchorPane();
          root = App.root;   
        try {
            center = FXMLLoader.load(getClass().getResource("/view/CadastrarProduto.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ExibirProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
          root.setCenter(center);
    }

    @FXML
    private void btnPesquisarOnAction(javafx.event.ActionEvent event) {
    }

   
    
}
