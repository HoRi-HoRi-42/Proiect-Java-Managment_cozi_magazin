package Model;

import GUI.GUI;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Que extends Thread {
    public BlockingQueue<Client> clienti;
    private AtomicInteger perioadaAsteptare;
    Thread t;

    public Que() {
        clienti = new ArrayBlockingQueue<Client>(50);
        perioadaAsteptare = new AtomicInteger(0);
        t = new Thread(this);
        t.start();
    }

    public void addClient(Client newClient) {
        clienti.add(newClient);
        perioadaAsteptare.addAndGet(newClient.getServire());
    }

    public void run() {
        while (true) {
            if (!clienti.isEmpty()) {
                Client c = clienti.element();
                try {
                    Thread.sleep(c.getServire() * 1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                }
                GUI.setLogData("Clientul " + c.getID() + " a fost servit\n");
                clienti.remove();
            }
        }
    }

    public ArrayList<Client> getClienti() {
        ArrayList<Client> clent = new ArrayList<Client>();

        for (Client c : clienti) {
            clent.add(c);
        }
        return clent;

    }

    public String toString() {
        String clent = new String();
        for (Client c : clienti) {
            clent += "C" + c.getID() + " ";
        }
        return clent;
    }

    public AtomicInteger getPerioadaAsteptare() {
        return perioadaAsteptare;
    }

    public void setPerioadaAsteptare(int perioadaAsteptare) {
        this.perioadaAsteptare.set(perioadaAsteptare);
    }


}
