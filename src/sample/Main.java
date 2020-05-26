package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Modelos.CRUDProductos;
import sample.Modelos.Conexion;
import sample.Vistas.Buscaminas;
import sample.Vistas.PistaAtletismo;
import sample.Vistas.ServidorSocket;
import sample.Vistas.Taquimecanografo;

public class Main extends Application {
    MenuItem mitPractica1,mitPractica2,mitPractica3,mitPractica4,mitBye;
    MenuBar mnbProyecto;
    Menu menCompetencia1,menCompetencia2,mensalir;
    Scene escena;
    BorderPane brpPrincipal;
    @Override
    public void start(Stage primaryStage) throws Exception{
        brpPrincipal = new BorderPane();

        mnbProyecto = new MenuBar();
        brpPrincipal.setTop(mnbProyecto);
        menCompetencia1 = new Menu("1er. Competencia");
        menCompetencia2 = new Menu("2da. Competencia");
        mensalir = new Menu("Salir");

        mitPractica1 = new MenuItem("Buscaminas");
        mitPractica1.setOnAction(event -> OpcionMenu(1));

        mitPractica2 = new MenuItem("Taquimecanografo");
        mitPractica2.setOnAction(event -> OpcionMenu(2));

        mitPractica3 = new MenuItem("CRUD Productos");
        mitPractica3.setOnAction(event -> OpcionMenu(3));

        mitPractica4 = new MenuItem("Pista de Atletismo");
        mitPractica4.setOnAction(event -> OpcionMenu(4));

        mitBye = new MenuItem("Bye");
        mitBye.setOnAction(event -> OpcionMenu(20));

        menCompetencia1.getItems().addAll(mitPractica1,mitPractica2);
        menCompetencia2.getItems().addAll(mitPractica3,mitPractica4);
        mensalir.getItems().add(mitBye);

        //Pasarlos al menu bar
        mnbProyecto.getMenus().addAll(menCompetencia1,menCompetencia2,mensalir);
        escena = new Scene(brpPrincipal,380,293);

        //Creamos la conexion a la base de datos
        Conexion.CrearConexion();

        primaryStage.setTitle("Hello Topicos :)");
        primaryStage.setScene(escena);
        escena.getStylesheets().add("estilos/estilos_principal.css");

        primaryStage.setMaximized(true);
        primaryStage.show();

        /*
        new Hilo("Rubensin").start();
        new Hilo("El prisas").start();
        new Hilo("Sonic").start();
        new Hilo("Limas").start();
        new Hilo("Hulk").start();


        RecursoCompartido objRec = new RecursoCompartido();
        new ProductorThread(objRec).start();
        new ConsumidorThread(objRec).start();

         */
        //new ServidorSocket().iniciarServidor();

    }

    private void OpcionMenu(int i) {
        switch(i){
            case 1:
                new Buscaminas();
                break;
            case 2:
                new Taquimecanografo();
                break;
            case 3:
                new CRUDProductos();
                break;
            case 4:
                new PistaAtletismo();
                break;
            case 20:
                System.exit(0);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
