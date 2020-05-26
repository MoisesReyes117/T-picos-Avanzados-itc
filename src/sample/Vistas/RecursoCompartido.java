package sample.Vistas;

public class RecursoCompartido {
    public int[] arreglo = new int[5];
    public int tope = 0;
    public boolean detenerHilo = false;

    public synchronized void LlenarRecurso (int valor){
        try {

            while (detenerHilo){
                System.out.println("Se detuvo el hilo productor");
                wait();
                System.out.println("Se reanudo el hilo productor");
            }

            System.out.println("Recurso["+tope+"] = "+valor);
            arreglo[tope] = valor;
            tope++;
            if (tope == arreglo.length){
                detenerHilo = true;
                tope--;
                notify();
            }
        }catch (Exception e){ e.printStackTrace();}
    }
    public synchronized void VaciarTecurso(){
        try {
            while (detenerHilo == false){
                System.out.println("Se detuvo el hilo consumidor");
                wait();
                System.out.println("Se reanudo el hilo consumidor");
            }
            System.out.println("valor = Recurso["+tope+"] : "+arreglo[tope]);
            tope--;
            if (tope < 0){
                tope++;
                detenerHilo = false;
                notify();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
