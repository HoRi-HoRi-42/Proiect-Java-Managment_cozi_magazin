package Control;

import GUI.GUI;
import Model.Manager;

public class Main {
    public static void main( String[] args )
    {
         GUI frame;
        System.out.println( "Hello World!" );
        Manager m = new Manager();
        Thread t = new Thread(m);
        t.start();
        //frame = new GUI();

    }

}
