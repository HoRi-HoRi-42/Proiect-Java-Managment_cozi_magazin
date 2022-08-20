package Control;

import Model.Client;
import Model.Que;

import java.util.List;

public interface Strategy {
    public void addClient(List<Que> coad, Client clnt);

    public enum SelectionPolicy {SHORTEST_QUEUE, SHORTEST_TIME}
}
