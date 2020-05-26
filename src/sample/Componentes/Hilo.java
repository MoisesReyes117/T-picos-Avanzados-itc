package sample.Componentes;

public class Hilo extends Thread {
    public Hilo(String nomHilo) {
        setName(nomHilo);
    }

    @Override
    public void run(){
        System.out.println("Inicia Corredor"+getName());
        for (int i = 1; i < 5 ; i++) {
            try {

                sleep( (long)( Math.random() * 2000) );

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Corredor "+getName()+" termino el km "+i);
        }
        System.out.println("Corredor "+getName()+" llego a la meta");
    }
}
// Sonik hilo1, Rubensin hilo2, Hulk hilo3, El prisas hilo4, Limas hilo5