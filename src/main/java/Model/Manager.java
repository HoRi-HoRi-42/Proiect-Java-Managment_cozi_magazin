package Model;

import GUI.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Manager implements Runnable {
    public int timeLimit;
    private int nrCode;
    public int nrClienti;
    public int intMinServire;
    public int intMaxServire;
    public int intMinSosire;
    public int IntMaxSosire;
    public int medieServire;
    public int medieSosire;

    //public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    public static int intSimulare;

    public List<Client> clientiNormali = new ArrayList<Client>();
    public List<Client> clientiiRandimi = new ArrayList<Client>();
    //private Scheduler scheduler;
    public GUI frame;


    public Manager() {
        frame = new GUI();
    }

    public void GenereClient() {
        for (int i = 0; i < nrClienti; i++) {
            Client c = new Client(i + 1, 1, 1);
            clientiNormali.add(c);
        }
    }

    public void RandmozareClienti(int timMin, int timMax, int serMin, int serMax) {
        int tmin = timMin;
        int tmax = timMax;
        int smin = serMin;
        int smax = serMax;
        for (Client c : clientiNormali
        ) {
            c.setServire((int) Math.floor(Math.random() * ( tmax - tmin+ 1) + tmin));
            c.setSosire((int) Math.floor(Math.random() * (smax - smin+ 1) + smin));
            clientiiRandimi.add(c);
        }

    }

    // public int randomizare (C)

    public void run() {
        // TODO Auto-generated method stub

        while(true){
            if(frame.adevarat == 0) System.out.println(" ");
                else break;
        }

        timeLimit = frame.timeLimit;
        nrCode = frame.cozi;
        nrClienti = frame.clienti;
        intMinServire = frame.intMinServire;
        intMaxServire = frame.intMaxServire;
        intMinSosire = frame.intMinSosire;
        IntMaxSosire = frame.intMaxSosire;

        //Scheduler = new Scheduler(nrCode);
        GenereClient();
        System.out.println(clientiNormali.toString());
        RandmozareClienti(intMinServire, intMaxServire, intMinSosire, IntMaxSosire);
        System.out.println(clientiiRandimi.toString());


        while (intSimulare < timeLimit) {
            frame.simTime.setText("Timp simulare: " + intSimulare + "\n");
            frame.setLogData("\nSecunda " + intSimulare + "\n");
            for (Client c : clientiiRandimi) {
                if (c.getSosire() == intSimulare) {
                    // scheduler.dispatchClient(c);
                }
            }

//            for (Coada q : scheduler.getCozi()) {
//                if (q.getPerioadaAsteptare().get() > 0) {
//                    q.setPerioadaAsteptare(q.getPerioadaAsteptare().get() - 1);
//                }
//            }

            //frame.updateCozi(scheduler.getCozi());

            intSimulare++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        medii();

    }

//    private void generateClients() {
//        for (int i = 0; i < nrClienti; i++) {
//            int arrTime = (int) (Math.random() * timeLimit);
//            int procTime = (int) (intMinServire + Math.random() * (intMaxServire - intMinServire + 1));
//
//            Client c = new Client(i + 1, arrTime, procTime);
//           // clienti.add(c);
//        }
//     }


    public void medii() {
        float sum1 = 0;
        float sum2 = 0;
        int increment = 0;
        for (Client c :
                clientiiRandimi) {
            sum2 += c.getSosire();
            sum1 += c.getServire();
            increment += 1;
        }
        System.out.printf("medie servire: %fd, medie sosire: %fd", sum1 / increment, sum2 / increment);
    }
}