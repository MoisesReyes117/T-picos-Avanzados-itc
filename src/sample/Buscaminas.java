package sample;

import Eventos.EventoBuscaminas;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buscaminas extends Stage implements EventHandler {
    private GridPane gdpCampo;
    private Button [][] arBtnCeldas;
    private Scene escena;
    private HBox hbox;
    private VBox vbox;
    private Button btnMinar;
    private Label lblNoRows, lblNoCols;
    private TextField txtNoRows, txtNoCols;



    public Buscaminas(){
        CrearGUI();
        this.setTitle("Mi Buscaminas chidote :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vbox = new VBox();
        hbox = new HBox();
        lblNoRows= new Label("No. Rows");
        lblNoCols = new Label("No. Cols");
    btnMinar = new Button("Minar Campo");
    //btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoBuscaminas(txtNoRows,txtNoCols));
       /* btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mi Tercer Evento :)");
            }
        });
       btnMinar.setOnAction(event -> {
           System.out.println("Mi Cuarto Evento :)");
       });


       btnMinar.setOnAction(event -> Evento());

        */
    }

    private void Evento() {
        System.out.println(" Mi Quinto Evento :)");
    }

    @Override
    public void handle(Event event) {
        System.out.println("Mi Primer Evento :)");
    }
}
