package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    //private Button btn1,btn2,btn3,btn4;

    private HBox hbox;
    private VBox vbox;
    private MenuItem mitPractica1,mitBye;
    private MenuBar mnbProyecto;
    private Menu menCompetencia1,menCompetencia2,mensalir;
    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml");
        btn1 = new Button("Btn1");
        btn1.setPrefWidth(100);

        btn2 = new Button("Btn2");
        btn2.setPrefWidth(100);

        btn3 = new Button("Btn3");
        btn3.setPrefWidth(300);

        btn4 = new Button("Btn4");
        btn4.setPrefWidth(300);

        hbox = new HBox();
        vbox = new VBox();

        hbox.setSpacing(10);
        vbox.setSpacing(15);

        hbox.getChildren().addAll(btn3,btn4);
        vbox.getChildren().addAll(btn1,btn2,hbox);

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Mi primera escena :)");
        primaryStage.setScene(new Scene(vbox,300,275));
        primaryStage.show();
        */
        mnbProyecto = new MenuBar();
        menCompetencia1 = new Menu("1er. Competencia");
        menCompetencia2 = new Menu("2da. Competencia");
        mensalir = new Menu("Salir");

        mitPractica1 = new MenuItem("Practica 1");
        mitPractica1.setOnAction(event -> OpcionMenu(1));

        mitBye = new MenuItem("Bye");
        mitBye.setOnAction(event -> OpcionMenu(20));

        menCompetencia1.getItems().add(mitPractica1);
        mensalir.getItems().add(mitBye);

        //Pasarlos al menu bar
        mnbProyecto.getMenus().addAll(menCompetencia1,menCompetencia2,mensalir);



        primaryStage.setTitle("Hello Topicos :)");
        primaryStage.setScene(new Scene(mnbProyecto, 300, 275));
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    private void OpcionMenu(int i) {
        switch(i){
            case 1:
                new Buscaminas();
                break;
            case 20:
                System.exit(0);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
