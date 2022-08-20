package Control;

import GUI.GUI;
import Model.Client;
import Model.Que;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {

    public void addClient(List<Que> cozi, Client c) {
        // TODO Auto-generated method stub
        int min = 99999;
        Que q = null;
        for (Que dd : cozi) {
            if (dd.getPerioadaAsteptare().get() < min) {
                min = dd.getPerioadaAsteptare().get();
                q = dd;
            }
        }
        q.addClient(c);
        GUI.setLogData("Clientul " + c.getID() + " se afla la coada " + (cozi.indexOf(q) + 1) + " cu timpul de servire " + c.getServire() + "\n");
    }

}
