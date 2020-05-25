package Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class EventoBuscaminas implements EventHandler{
    private TextField txtnr;
    private TextField txtnc;
    private GridPane gdpCampo;
    private Button[][] arBtnCeldas;
    private VBox vbox;

public EventoBuscaminas(TextField txtNr,TextField txtNc,Button[][] arBtnCELDAS,GridPane gdpCAMPO,VBox vBOX){
    this.txtnr = txtNr;
    this.txtnc = txtNc;
    this.arBtnCeldas = arBtnCELDAS;
    this.gdpCampo = gdpCAMPO;
    this.vbox = vBOX;
}

    @Override
    public void handle(Event event) {
    int nr = Integer.parseInt(this.txtnr.getText());
    int nc = Integer.parseInt(this.txtnc.getText());

    if(arBtnCeldas !=null){
        vbox.getChildren().remove(gdpCampo);
    }
        arBtnCeldas = new Button[nr][nc];
        gdpCampo = new GridPane();
        gdpCampo.setPadding(new Insets(15));
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc ; j++) {
                arBtnCeldas[i][j] = new Button(i+"-"+j);
                arBtnCeldas[i][j].setPrefSize(80,80);
                arBtnCeldas[i][j].setStyle("-fx-base:#00796b; -fx-background-radius:10;");
                gdpCampo.add(arBtnCeldas[i][j],j,i);
            }
        }
        this.vbox.getChildren().add(this.gdpCampo);

    }
}
