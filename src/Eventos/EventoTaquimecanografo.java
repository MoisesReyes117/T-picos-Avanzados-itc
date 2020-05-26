package Eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventoTaquimecanografo implements EventHandler<KeyEvent> {
    Button[] arbBotones1,arbBotones2,arbBotones3,arbBotones4,arbBotones5,arbBotones6;
    Boolean ban = true;
    public EventoTaquimecanografo (Button[] arbtn1,Button[] arbtn2,Button[] arbtn3,Button[] arbtn4,Button[] arbtn5,Button[] arbtn6){
        arbBotones1 = arbtn1;
        arbBotones2 = arbtn2;
        arbBotones3 = arbtn3;
        arbBotones4 = arbtn4;
        arbBotones5 = arbtn5;
        arbBotones6 = arbtn6;
    }
    @Override
    public void handle(KeyEvent event) {
        int post = -1;
        int post2 = -1;
        int post3 = -1;
        int post4 = -1;
        int post5 = -1;
        int post6 = -1;
       Object source = event.getSource();

        if( event.getCode() == KeyCode.ESCAPE)
            post = 0;
        if( event.getCode() == KeyCode.HELP)
            post = 1;
        if( event.getCode() == KeyCode.F2)
            post = 2;
        if( event.getCode() == KeyCode.F3)
            post = 3;
        if( event.getCode() == KeyCode.F4)
            post = 4;
        if( event.getCode() == KeyCode.F5)
            post = 5;
        if( event.getCode() == KeyCode.MUTE)
            post = 6;
        if( event.getCode() == KeyCode.VOLUME_DOWN)
            post = 7;
        if( event.getCode() == KeyCode.VOLUME_UP)
            post = 8;
        if( event.getCode() == KeyCode.TRACK_PREV)
            post = 9;
        if( event.getCode() == KeyCode.PAUSE)
            post = 10;
        if( event.getCode() == KeyCode.TRACK_NEXT)
            post = 11;
        if( event.getCode() == KeyCode.F12)
            post = 12;
        if( event.getCode() == KeyCode.INSERT)
            post = 13;
        if( event.getCode() == KeyCode.DELETE)
            post = 14;

        if( event.getCode() == KeyCode.BACK_QUOTE)
            post2 = 0;
        if( event.getCode() == KeyCode.DIGIT1)
            post2 = 1;
        if( event.getCode() == KeyCode.DIGIT2)
            post2 = 2;
        if( event.getCode() == KeyCode.DIGIT3)
            post2 = 3;
        if( event.getCode() == KeyCode.DIGIT4)
            post2 = 4;
        if( event.getCode() == KeyCode.DIGIT5)
            post2 = 5;
        if( event.getCode() == KeyCode.DIGIT6)
            post2 = 6;
        if( event.getCode() == KeyCode.DIGIT7)
            post2 = 7;
        if( event.getCode() == KeyCode.DIGIT8)
            post2 = 8;
        if( event.getCode() == KeyCode.DIGIT9)
            post2 = 9;
        if( event.getCode() == KeyCode.DIGIT0)
            post2 = 10;
        //if( event.getCode() == KeyCode.DEAD_ACUTE)
           // post2 = 11;
        if( event.getCode() == KeyCode.EQUALS)
            post2 = 12;
        if( event.getCode() == KeyCode.BACK_SPACE)
            post2 = 13;



        if( event.getCode() == KeyCode.TAB)
            post3 = 0;
        if( event.getCode() == KeyCode.Q)
            post3 = 1;
        if( event.getCode() == KeyCode.W)
            post3 = 2;
        if( event.getCode() == KeyCode.E)
            post3 = 3;
        if( event.getCode() == KeyCode.R)
            post3 = 4;
        if( event.getCode() == KeyCode.T)
            post3 = 5;
        if( event.getCode() == KeyCode.Y)
            post3 = 6;
        if( event.getCode() == KeyCode.U)
            post3 = 7;
        if( event.getCode() == KeyCode.I)
            post3 = 8;
        if( event.getCode() == KeyCode.O)
            post3 = 9;
        if( event.getCode() == KeyCode.P)
            post3 = 10;
        if( event.getCode() == KeyCode.DEAD_ACUTE)
            post3 = 11;
        if( event.getCode() == KeyCode.PLUS)
            post3 = 12;
        if( event.getCode() == KeyCode.ENTER)
            post3 = 13;

        if( event.getCode() == KeyCode.CAPS)
            post4 = 0;
        if( event.getCode() == KeyCode.A)
            post4 = 1;
        if( event.getCode() == KeyCode.S)
            post4 = 2;
        if( event.getCode() == KeyCode.D)
            post4 = 3;
        if( event.getCode() == KeyCode.F)
            post4 = 4;
        if( event.getCode() == KeyCode.G)
            post4 = 5;
        if( event.getCode() == KeyCode.H)
            post4 = 6;
        if( event.getCode() == KeyCode.J)
            post4 = 7;
        if( event.getCode() == KeyCode.K)
            post4 = 8;
        if( event.getCode() == KeyCode.L)
            post4 = 9;
        //if( event.getCode() == KeyCode.UNDEFINED)
           // post4 = 10;
        if( event.getCode() == KeyCode.BRACELEFT)
            post4 = 11;
        if( event.getCode() == KeyCode.BRACERIGHT)
            post4 = 12;

        if( event.getCode() == KeyCode.SHIFT)
            post5 = 0;
        if( event.getCode() == KeyCode.PERIOD)
            post5 = 1;
        if( event.getCode() == KeyCode.Z)
            post5 = 2;
        if( event.getCode() == KeyCode.X)
            post5 = 3;
        if( event.getCode() == KeyCode.C)
            post5 = 4;
        if( event.getCode() == KeyCode.V)
            post5 = 5;
        if( event.getCode() == KeyCode.B)
            post5 = 6;
        if( event.getCode() == KeyCode.N)
            post5 = 7;
        if( event.getCode() == KeyCode.M)
            post5 = 8;
        if( event.getCode() == KeyCode.COMMA)
            post5 = 9;
        if( event.getCode() == KeyCode.PERIOD)
            post5 = 10;
        if( event.getCode() == KeyCode.MINUS)
            post5 = 11;
        if( event.getCode() == KeyCode.SHIFT)
            post5 = 12;
        if( event.getCode() == KeyCode.UP)
            post5 = 13;

        if( event.getCode() == KeyCode.CONTROL)
            post6 = 0;
        if( event.getCode() == KeyCode.FINAL)
            post6 = 1;
        if( event.getCode() == KeyCode.WINDOWS)
            post6 = 2;
        if( event.getCode() == KeyCode.ALT)
            post6 = 3;
        if( event.getCode() == KeyCode.SPACE)
            post6 = 4;
        if( event.getCode() == KeyCode.ALT_GRAPH)
            post6 = 5;
        if( event.getCode() == KeyCode.LEFT)
            post6 = 7;
        if( event.getCode() == KeyCode.DOWN)
            post6 = 8;
        if( event.getCode() == KeyCode.RIGHT)
            post6 = 9;






        if(post !=-1) {
            if (ban) {
                arbBotones1[post].setStyle("-fx-base: #DAABFF");
            } else {
                arbBotones1[post].setStyle("-fx-base: #B4EAFF");
            }
        }else {
            if(post2 !=-1){
               if (ban) {
                arbBotones2[post2].setStyle("-fx-base: #DAABFF");
               } else {
                arbBotones2[post2].setStyle("-fx-base: #B4EAFF");
               }
            }else{
                if(post3 !=-1){
                    if(ban) {
                        arbBotones3[post3].setStyle("-fx-base: #DAABFF");
                    }else {
                        arbBotones3[post3].setStyle("-fx-base: #B4EAFF");
                    }
                }else{
                    if(post4 !=-1){
                        if(ban) {
                            arbBotones4[post4].setStyle("-fx-base: #DAABFF");
                        }else {
                            arbBotones4[post4].setStyle("-fx-base: #B4EAFF");
                        }
                    }else{
                        if (post5 !=-1) {
                            if(ban) {
                                if (post5 == 12) {
                                    arbBotones5[0].setStyle("-fx-base: #DAABFF");
                                    arbBotones5[12].setStyle("-fx-base: #DAABFF");
                                } else {
                                    arbBotones5[post5].setStyle("-fx-base: #DAABFF");
                                }
                            }else{
                                    arbBotones5[post5].setStyle("-fx-base: #B4EAFF");
                                arbBotones5[0].setStyle("-fx-base: #B4EAFF");
                                arbBotones5[12].setStyle("-fx-base: #B4EAFF");

                            }
                        }else{
                            if(post6 !=-1){
                                if(ban) {
                                    if (post6 == 0) {
                                        arbBotones6[0].setStyle("-fx-base: #DAABFF");
                                        arbBotones6[6].setStyle("-fx-base: #DAABFF");
                                    } else {
                                        arbBotones6[post6].setStyle("-fx-base: #DAABFF");
                                    }
                                }else{
                                    arbBotones6[post6].setStyle("-fx-base: #B4EAFF");
                                    arbBotones6[0].setStyle("-fx-base: #B4EAFF");
                                    arbBotones6[6].setStyle("-fx-base: #B4EAFF");

                                }
                            }
                        }
                    }
                }
            }
        }
        ban = !ban;




    }
}
