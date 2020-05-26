package sample.Componentes;

import sample.Vistas.RecursoCompartido;

public class ConsumidorThread extends Thread {
    RecursoCompartido objRec;
    public ConsumidorThread (RecursoCompartido objRec){
        this.objRec = objRec;
    }
    @Override
    public void run() {
        super.run();
        System.out.println("inicia hilo consumidor");
        for (int i = 1; i < 51 ; i++) {
            objRec.VaciarTecurso();
        }
        System.out.println("termina hilo consumidor");
    }
}
