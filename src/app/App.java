package app;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author william
 */
public class App extends Application {
   private AnchorPane center = new AnchorPane();
   public static BorderPane root = new BorderPane();
    @Override
    public void start(Stage primaryStage) throws IOException {
        center = FXMLLoader.load(getClass().getResource("/view/ExibirProdutos.fxml"));
        root.setCenter(center);
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1920);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Tabelas no JavaFX");
        primaryStage.show();
    }
    public BorderPane getRoot(){
        return root;
    }
}