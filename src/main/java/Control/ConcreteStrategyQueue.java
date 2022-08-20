package Control;

import Model.Client;
import Model.Que;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy {
    public void addClient(List<Que> cozi, Client c) {
        // TODO Auto-generated method stub
        int min = cozi.get(0).getClienti().size();
        Que x = null;
        for (Que dd : cozi) {
            if (dd.getClienti().size() < min) {
                min = dd.getClienti().size();
                x = dd;
            }
        }
        x.addClient(c);
    }


}
