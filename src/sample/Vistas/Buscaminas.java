package sample.Vistas;

import Eventos.EventoBuscaminas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        lblNoRows= new Label(" No. Filas ");
        lblNoRows.setId("texto");
        lblNoRows.setTextFill(Color.WHITE);
        lblNoCols = new Label(" No. Cololumnas ");
        lblNoCols.setId("texto");
        lblNoCols.setTextFill(Color.WHITE);
        btnMinar = new Button("Minar Campo");
        txtNoCols = new TextField();
        txtNoRows = new TextField();
        btnMinar.setId("boton");
        btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoBuscaminas(txtNoRows,txtNoCols,arBtnCeldas,gdpCampo,vbox));
        hbox.getChildren().addAll(lblNoRows,txtNoRows,lblNoCols,txtNoCols,btnMinar);
        hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(hbox);
        escena = new Scene(vbox,800,500);
        escena.getStylesheets().add("estilos/estilos_buscaminas.css");

    }

    @Override
    public void handle(Event event) {
        System.out.println("Mi Primer Evento :)");
    }
}
