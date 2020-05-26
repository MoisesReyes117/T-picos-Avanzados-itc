package sample.Componentes;

import sample.Vistas.RecursoCompartido;

public class ProductorThread extends Thread {

        RecursoCompartido objRec;
        public ProductorThread (RecursoCompartido objRec){
            this.objRec = objRec;
        }
        @Override
        public void run() {
            super.run();
            System.out.println("inicia hilo productor");
            for (int i = 1; i < 51 ; i++) {
                objRec.LlenarRecurso(i);
            }
            System.out.println("termina hilo productor");
        }
}
