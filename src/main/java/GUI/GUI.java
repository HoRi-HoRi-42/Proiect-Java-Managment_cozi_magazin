package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class GUI extends JFrame {
    //private static final long serialVersionUID = 1L;
    private JPanel panel;
    public JTextField limitaTimp = new JTextField();
    public JTextField minServ = new JTextField();
    public JTextField maxServ = new JTextField();
    public JTextField MaxSosire = new JTextField();
    public JTextField MinSosire = new JTextField();
    public JTextField nrCozi = new JTextField();
    public JTextField nrClienti = new JTextField();

    public int timeLimit;
    public int intMinServire;
    public int intMaxServire;
    public int intMaxSosire;
    public int intMinSosire;
    public int cozi;
    public int clienti;

    public boolean go;
    public int adevarat =0;

    JPanel panel11 = new JPanel();
    public JLabel simTime = new JLabel("Timpul simularii: ");
    public JLabel[] lCoada;
    public JLabel[] lWaitingTime;
    public JTextField[] tfCoada;
    public JPanel[] pCoada;

    public static JTextArea logData = new JTextArea("----Log de evenimente----\n");

    public GUI() {
        panel = new JPanel();
        this.add(panel);
        panel.setLayout(new GridLayout(2, 1));
        this.setSize(820, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JLabel tl = new JLabel("Timpul limita");
        JLabel mins = new JLabel("Timpul Minim De Servire");
        JLabel maxs = new JLabel("Timpul Maxim De Servire");
        JLabel maxsos = new JLabel("Timpul Maxim De Sosire");
        JLabel minsos = new JLabel("Timpul Maxim De Sosire");

        JLabel cz = new JLabel("Numarul De Cozi");
        JLabel cl = new JLabel("Numarul De Clienti");

        limitaTimp.setColumns(22);
        minServ.setColumns(22);
        maxServ.setColumns(22);
        MinSosire.setColumns(20);
        MaxSosire.setColumns(20);
        nrCozi.setColumns(21);
        nrClienti.setColumns(21);


        JButton check = new JButton("Ruleaza");
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLimit = Integer.parseInt(limitaTimp.getText());
                intMinServire = Integer.parseInt(minServ.getText());
                intMaxServire = Integer.parseInt(maxServ.getText());
                int
                cozi = Integer.parseInt(nrCozi.getText());
                clienti = Integer.parseInt(nrClienti.getText());

                setFrame(cozi);
                adevarat = 1;
                go = true;

            }
        });

        JCheckBox checkBox1 = new JCheckBox("Cel mai scurt timp");
        checkBox1.setBounds(100, 100, 50, 50);
        JCheckBox checkBox2 = new JCheckBox("Cele mai scurte cozi", true);
        checkBox2.setBounds(100, 150, 50, 50);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        panel.add(p1);
        panel.add(p2);

        p1.setLayout(new GridLayout(1, 10));
        JPanel butoane = new JPanel();
        butoane.add(tl);
        butoane.add(limitaTimp);
        butoane.add(cz);
        butoane.add(nrCozi);
        butoane.add(cl);
        butoane.add(nrClienti);
        butoane.add(mins);
        butoane.add(minServ);
        butoane.add(maxs);
        butoane.add(maxServ);
        butoane.add(maxsos);
        butoane.add(MaxSosire);
        butoane.add(minsos);
        butoane.add(MinSosire);

        butoane.add(check);

        butoane.add(checkBox1);
        butoane.add(checkBox2);

        p1.add(butoane);

        p1.add(panel11);

        JScrollPane sp = new JScrollPane(logData);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(500, 200));
        p2.add(sp);
        this.revalidate();
    }

    public void setFrame(int nrCozi) {
        JFrame newFrame = new JFrame();
        newFrame.setVisible(true);
        newFrame.setSize(820, 800);

        lCoada = new JLabel[nrCozi];
        lWaitingTime = new JLabel[nrCozi];
        tfCoada = new JTextField[nrCozi];
        pCoada = new JPanel[nrCozi];


        newFrame.add(simTime);

        for (int i = 0; i < nrCozi; i++) {
            pCoada[i] = new JPanel();
            newFrame.add(pCoada[i]);
            lCoada[i] = new JLabel("Coada " + (i + 1));
            pCoada[i].add(lCoada[i]);
            tfCoada[i] = new JTextField();
            tfCoada[i].setColumns(10);
            pCoada[i].add(tfCoada[i]);
            lWaitingTime[i] = new JLabel("Timp asteptare ");
            pCoada[i].add(lWaitingTime[i]);
        }

        this.revalidate();
    }

//    public void updateCozi(List<Coada> cd) {
//        for (int i = 0; i <cozi; i++)
//        {
//            tfCoada[i].setText(cd.get(i).toString());
//            lWaitingTime[i].setText("T asteptare: "+cd.get(i).getPerioadaAsteptare().get());
//        }
//    }

    public static void setLogData(String strg) {
        logData.setText(logData.getText() + strg);
    }

}
