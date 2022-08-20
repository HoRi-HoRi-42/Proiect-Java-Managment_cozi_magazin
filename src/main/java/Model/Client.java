package Model;

public class Client {
    private int idClient; /// id unuic de generare a cluientului
    private int sos; //intervalul de asteptare in magazin
    private int serv; //intervalul de asteptare la coada

    public Client(int id, int sos, int serv)
    {
        this.idClient = id;
        this.sos = sos;
        this.serv = serv;
    }

    public int getID ()
    {
        return idClient;
    }

    public void setID(int id)
    {
        this.idClient = id;
    }

    public int getSosire()
    {
        return sos;
    }

    public void setSosire(int x)
    {
        this.sos = x;
    }

    public int getServire()
    {
        return serv;
    }

    public void setServire(int y)
    {
        this.serv = y;
    }

    public String toString()
    {
        return "ID client: " + idClient + ", timpul asteptat in magazin: " + sos + ", iar timpul asteptat in coada este: " + serv;
    }

}