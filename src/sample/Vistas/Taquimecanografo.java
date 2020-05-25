package sample;

import Eventos.EventoTaquimecanografo;
import Eventos.EventoVentanaTaqui;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;

public class Taquimecanografo extends Stage {
    private Scene escena;
    private ToolBar tlbMenu;
    private Button btnAbrir;
    private TextArea txaTexto,txaEscritura;
    private VBox vPrincipal, vTeclado;
    private HBox hTeclas1,hTeclas2,hTeclas3,hTeclas4,hTeclas5,hTeclas6;
    private Button [] arBotones1,arBotones2,arBotones3,arBotones4,arBotones5,arBotones6;
    private String[] arTeclas1 = {"esc","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12","imp pnt","supr"};
    private String[] arTeclas2 = {"|","1","2","3","4","5","6","7","8","9","0","'","¿","Delete"};
    private String[] arTeclas3 = {"Tab","Q","W","E","R","T","Y","U","I","O","P","´","+","Enter"};
    private String[] arTeclas4 = {"bloq mayús","A","S","D","F","G","H","J","K","L","Ñ","{","}"};
    private String[] arTeclas5 = {"Shift","<","Z","X","C","V","B","N","M",",",".","-","Shift","Arriba"};
    private String[] arTeclas6 = {"Ctrl","Fn","Windows","Alt","      Espacio     ","Alt gr","Ctrl","Izq","Abajo","Der"};
    private FileChooser flcArchivos;

    public Taquimecanografo () {
        CrearGUI();
        this.setTitle("mi tutor de caligrafía");
        this.setScene(escena);
        this.show();
        this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventoVentanaTaqui());

    }

    private void CrearGUI() {
        tlbMenu = new ToolBar();
        btnAbrir = new Button();
        btnAbrir.setGraphic(new ImageView("Imagenes/open.png"));
        btnAbrir.setOnAction(event -> AbrirExplorador());
        tlbMenu.getItems().add(btnAbrir);

        txaTexto = new TextArea();
        txaTexto.setEditable(false);
        txaTexto.setPrefRowCount(5);


        txaEscritura = new TextArea();
        txaEscritura.setPrefRowCount(5);


        hTeclas1 = new HBox();
        hTeclas2 = new HBox();
        hTeclas3 = new HBox();
        hTeclas4 = new HBox();
        hTeclas5 = new HBox();
        hTeclas6 = new HBox();
        arBotones1 = new Button[15];arBotones2 = new Button[14];arBotones3 = new Button[14];arBotones4 = new Button[13];arBotones5 = new Button[14];arBotones6 = new Button[11];
        for (int i = 0; i < 14; i++) {
            arBotones3[i] = new Button(arTeclas3[i]);
            hTeclas3.getChildren().add(arBotones3[i]);

            if(i != 0 && i !=(arBotones3.length-1))
                arBotones3[i].setId("btnRowNormal");
            else
                arBotones3[i].setId("btnLarga");
        }
        for (int i = 0; i < 14; i++) {
            arBotones2[i] = new Button(arTeclas2[i]);
            hTeclas2.getChildren().add(arBotones2[i]);
            if(i != 0 && i !=(arBotones2.length-1))
                arBotones2[i].setId("btnRowNormal");
            if(i==13)
                arBotones2[i].setId("btnLarga");
            if(i==0)
                arBotones2[i].setId("btnCorta");
        }
        for (int i = 0; i < 15; i++) {
            arBotones1[i] = new Button(arTeclas1[i]);
            hTeclas1.getChildren().add(arBotones1[i]);
            arBotones1[i].setId("btnFuncion");
        }
        for (int i = 0; i < 13; i++) {
            arBotones4[i] = new Button(arTeclas4[i]);
            hTeclas4.getChildren().add(arBotones4[i]);
            if(i==0)
                arBotones4[i].setId("btnLarga");
            else
                arBotones4[i].setId("btnRowNormal");
        }
        for (int i = 0; i < 14; i++) {
            arBotones5[i] = new Button(arTeclas5[i]);
            hTeclas5.getChildren().add(arBotones5[i]);
            if(i==12)
                arBotones5[i].setId("btnLarga");
            else
                arBotones5[i].setId("btnRowNormal");
        }
        for (int i = 0; i < 10; i++) {
            arBotones6[i] = new Button(arTeclas6[i]);
            hTeclas6.getChildren().add(arBotones6[i]);
            if(i==4)
                arBotones6[i].setId("btnEspacio");
            else
                arBotones6[i].setId("btnRowNormal");
        }
        hTeclas1.setAlignment(Pos.CENTER);
        hTeclas2.setAlignment(Pos.CENTER);
        hTeclas3.setAlignment(Pos.CENTER);
        hTeclas4.setAlignment(Pos.CENTER);
        hTeclas5.setAlignment(Pos.CENTER);
        hTeclas6.setAlignment(Pos.CENTER);
        hTeclas1.setSpacing(5);
        hTeclas2.setSpacing(5);
        hTeclas3.setSpacing(5);
        hTeclas4.setSpacing(5);
        hTeclas5.setSpacing(5);
        hTeclas6.setSpacing(5);

        EventoTaquimecanografo objEvento = new EventoTaquimecanografo(arBotones1,arBotones2,arBotones3,arBotones4,arBotones5,arBotones6);
        txaEscritura.setOnKeyPressed(objEvento);
        txaEscritura.setOnKeyReleased(objEvento);

        vTeclado = new VBox();
        vTeclado.getChildren().addAll(hTeclas1,hTeclas2,hTeclas3,hTeclas4,hTeclas5,hTeclas6);
        vTeclado.setSpacing(5);

        vPrincipal = new VBox();
        vPrincipal.setSpacing(5);
        vPrincipal.getChildren().addAll(tlbMenu, txaTexto, txaEscritura, vTeclado);
        escena = new Scene(vPrincipal, 900, 600);
        vPrincipal.getStylesheets().add("estilos/estilo_taqui.css");
    }

    private void AbrirExplorador(){
        flcArchivos = new FileChooser ();
        flcArchivos.setTitle("Archivo para Taquimecanografo");
        File objFile = flcArchivos.showOpenDialog(this);
    }



}
