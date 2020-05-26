package Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.RandomAccessFile;
import java.net.URL;

public class EventoBuscar implements EventHandler<MouseEvent>{

    private int i,j,TR,nr,nc,mina,numMinas;
    private RandomAccessFile fl;
    private Button[][] arBtnCeldas;
    private VBox vbox;
    private GridPane gdpCampo;
    int n = 1;
    int minaE = 0;
    int total;
    int baas = 13;
    private int BtnRe = 0;
    boolean ban = true;

    public EventoBuscar (Button[][] arBotonesx,int id,int ix,int jx,int NR,int NC,VBox vbox,GridPane gdpCampo,int numMina){
        this.i = ix;
        this.j = jx;
        this.TR = id;
        this.nr = NR;
        this.nc = NC;
        this.arBtnCeldas = arBotonesx;
        this.vbox = vbox;
        this.gdpCampo = gdpCampo;
        this.numMinas = numMina;
        total = nr * nc;
    }
    @Override
    public void handle(MouseEvent event) {
            if (event.getButton() == MouseButton.PRIMARY) {
                try {
                    TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                    fl = new RandomAccessFile("Buscaminas.dat", "rw");
                    fl.seek(0);
                    fl.seek(TR);
                    mina = fl.read();
                    fl.seek(0);
                   if (mina == 0) {

                        buscar(i, j, n);

                        for (int k = 0; k < nr ; k++) {
                            for (int h = 0; h < nc  ; h++) {
                                String revi = arBtnCeldas[k][h].getId();
                                if(revi == "REVISADO"){
                                    BtnRe +=1;
                                }
                            }
                        }

                        //System.out.println("minas "+numMinas+" revisadas "+BtnRe+" total "+total);
                        if ((numMinas+BtnRe) != total) {

                        }else {
                            Alert objAlert = new Alert (Alert.AlertType.INFORMATION);
                            URL imagen = getClass().getResource("../Imagenes/ganaste.png");
                            Image victoria = new Image(imagen.toString(), 100, 100, true, false);
                            objAlert.setGraphic(new ImageView(victoria));
                            objAlert.setTitle("Buscaminas");
                            objAlert.setHeaderText("          Felicidades Ganaste :)");
                            objAlert.setContentText("                              Game Over");
                            objAlert.showAndWait();
                            vbox.getChildren().remove(gdpCampo);
                        }

                    } else {

                        fl.seek(0);
                        Alert objAlert = new Alert (Alert.AlertType.INFORMATION);
                        URL imagen = getClass().getResource("../Imagenes/perdiste.png");
                        Image perdiste = new Image(imagen.toString(), 90, 90, true, false);
                        objAlert.setGraphic(new ImageView(perdiste));
                        objAlert.setTitle("Buscaminas");
                        objAlert.setHeaderText("          BOOM!!!  Acabas de explotar :(");
                        objAlert.setContentText("                              Game Over");
                        objAlert.showAndWait();
                        vbox.getChildren().remove(gdpCampo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (event.getButton() == MouseButton.SECONDARY) {
                if (ban == true) {
                    URL imagen = getClass().getResource("../Imagenes/bandera.png");
                    Image bandera = new Image(imagen.toString(), 30, 30, true, false);
                    //arBtnCeldas[i][j].setText("");
                    arBtnCeldas[i][j].setGraphic(new ImageView(bandera));

                    try {
                        fl = new RandomAccessFile("Buscaminas.dat", "rw");
                        fl.seek(0);
                        TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                        fl.seek(TR);
                        mina = fl.read();
                        if (mina == 1) {
                            minaE++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    URL imagen = getClass().getResource("../Imagenes/bandera.png");
                    Image nada = new Image(imagen.toString(), 1, 1, true, false);
                    arBtnCeldas[i][j].setGraphic(new ImageView(nada));
                    try {
                        fl = new RandomAccessFile("Buscaminas.dat", "rw");
                        fl.seek(0);
                        TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                        fl.seek(TR);
                        mina = fl.read();
                        if (mina == 1) {
                            minaE--;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ban = !ban;

            }

    }

    public void buscar(int i, int j, int n){
        //System.out.println(TR);
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i >= 0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {

            try {
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl = new RandomAccessFile("Buscaminas.dat", "rw");
                fl.seek(0);
                fl.seek(TR);
                mina = fl.read();
                if (mina == 0) {

                    arBtnCeldas[i][j].setStyle("-fx-base:#FFFFFF;");
                    arBtnCeldas[i][j].setId("REVISADO");
                    arBtnCeldas[i][j].setDisable(true);
                    if (j == (nc - 1) && i == 0) {
                        //Esquina superior derecha
                        buscarIzquierda(i, (j - 1), n);
                        buscarDiagonalAbajoiz((i + 1), (j - 1), n);
                        buscarAbajo((i + 1), j, n);
                    } else {
                        if (j == (nc - 1) && i == (nr - 1)) {
                            //Esquina inferior derecha
                            buscarIzquierda(i, (j - 1), n);
                            buscarArriba((i - 1), j, n);
                            buscarDiagonalArribaiz((i - 1), (j - 1), n);
                        } else {
                            if (j == 0 && i == 0) {
                                // Esquina superior izquierda
                                buscarDerecha(i, (j + 1), n);
                                buscarAbajo((i + 1), j, n);
                                buscarDiagonalAbajoder((i + 1), (j + 1), n);
                            } else {
                                if (j == 0 && i == (nr - 1)) {
                                    // Esquina inferior izquierda
                                    buscarDerecha(i, (j + 1), n);
                                    buscarArriba((i - 1), j, n);
                                    buscarDiagonalArribader((i - 1), (j + 1), n);
                                } else {
                                    if (i == 0 && j > 0 && j < (nc - 1)) {
                                        // Centro superior
                                        buscarDerecha(i, (j + 1), n);
                                        buscarIzquierda(i, (j - 1), n);
                                        buscarAbajo((i + 1), j, n);
                                        buscarDiagonalAbajoder((i + 1), (j + 1), n);
                                        buscarDiagonalAbajoiz((i + 1), (j - 1), n);
                                    } else {
                                        if (j == 0 && i > 0 && i < (nr - 1)) {
                                            // Centro izquierdo
                                            buscarDerecha(i, (j + 1), n);
                                            buscarAbajo((i + 1), j, n);
                                            buscarArriba((i - 1), j, n);
                                            buscarDiagonalAbajoder((i + 1), (j + 1), n);
                                            buscarDiagonalArribader((i - 1), (j + 1), n);
                                        } else {
                                            if (i == (nr - 1) && j > 0 && j < (nc - 1)) {
                                                // Centro inferior
                                                buscarArriba((i - 1), j, n);
                                                buscarDerecha(i, (j + 1), n);
                                                buscarIzquierda(i, (j - 1), n);
                                                buscarDiagonalArribader((i - 1), (j + 1), n);
                                                buscarDiagonalArribaiz((i - 1), (j - 1), n);
                                            } else {
                                                if (j == (nc - 1) && i > 0 && i < (nr - 1)) {
                                                    // Centro derecho
                                                    buscarIzquierda(i, (j - 1), n);
                                                    buscarArriba((i - 1), j, n);
                                                    buscarAbajo((i + 1), j, n);
                                                    buscarDiagonalArribaiz((i - 1), (j - 1), n);
                                                    buscarDiagonalAbajoiz((i + 1), (j - 1), n);
                                                } else {
                                                    buscarDerecha(i, (j + 1), n);
                                                    buscarIzquierda(i, (j - 1), n);
                                                    buscarArriba((i - 1), j, n);
                                                    buscarAbajo((i + 1), j, n);
                                                    buscarDiagonalArribaiz((i - 1), (j - 1), n);
                                                    buscarDiagonalArribader((i - 1), (j + 1), n);
                                                    buscarDiagonalAbajoder((i + 1), (j + 1), n);
                                                    buscarDiagonalAbajoiz((i + 1), (j - 1), n);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    fl.seek(0);
                } else {
                    fl.seek(0);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    public void buscarIzquierda(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i ,j , n);
                } else {
                    int suma = 0;
                    String  val = arBtnCeldas[i][j + 1].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i][j + 1].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarDerecha(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i ,j , n);
                } else {
                    int suma = 0;
                    String  val = arBtnCeldas[i][j - 1].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i][j - 1].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarArriba(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i , j, n);
                } else {
                    int suma =0;
                    String  val = arBtnCeldas[i + 1][j].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i + 1][j].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarAbajo(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i , j, n);

                } else {
                    int suma =0;
                    String  val = arBtnCeldas[i - 1][j].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i - 1][j].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarDiagonalAbajoiz(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i ,j , n);
                } else {
                    int suma =0;
                    String  val = arBtnCeldas[i - 1][j + 1].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i - 1][j + 1].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarDiagonalAbajoder(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i ,j , n);


                } else {
                    int suma =0;
                    String  val = arBtnCeldas[i - 1][j - 1].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i - 1][j - 1].setText(""+(Math.abs(suma)));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarDiagonalArribader(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i, j, n);

                } else {
                    int suma =0;
                    String  val = arBtnCeldas[i + 1 ][j - 1].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i + 1][j - 1].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void buscarDiagonalArribaiz(int i, int j,int n){
        String ver = arBtnCeldas[i][j].getId();
        if(i<=(nr-1) && i>=0 && j<=(nc-1) && j>=0 && ver!="REVISADO") {
            try {
                fl.seek(0);
                TR = Integer.parseInt(arBtnCeldas[i][j].getId());
                fl.seek(TR);
                mina = fl.read();
                fl.seek(0);
                if (mina == 0) {
                    n++;
                    buscar(i ,j , n);
                } else {
                    int suma =0;
                    String  val = arBtnCeldas[i + 1][j + 1].getText();
                    if ( val == " "){
                    }else{
                        suma = Integer.parseInt(val);
                    }
                    suma = suma + 1;
                    arBtnCeldas[i + 1][j + 1].setText(""+(Math.abs(suma)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
