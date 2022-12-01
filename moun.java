import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class moun {
    public static void main(String[] args) {

        Myframe mf = new Myframe();
    }
}

class Myframe extends JFrame implements ListSelectionListener {
    final JList<String> list = new JList<String>();
    private JTextArea jt = new JTextArea("----Mountains in every city----", 5 ,10);

    public Myframe(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 500, 500);
        setLayout(null);
        JPanel bgp = new JPanel();
        setContentPane(bgp);
        bgp.setLayout(new BorderLayout());
        
        JLabel labelCity = new JLabel("Find mountain in Taiwan cities :");
        
      
        JPanel p1 = new JPanel();
        //p1.setBackground(Color.BLUE);
        p1.setLayout(new BorderLayout());
      
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //list.setListData(new String[]{"kaohsiung", "taipei", "chiayi", "nantou"});
        list.setListData(new String[]{"Kaohsiung", "Chayi", "Hsinchu" , "Taipei"});
        list.setVisibleRowCount(4);
        list.addListSelectionListener(this);
        
        JScrollPane sp1 = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
        p1.add(labelCity, BorderLayout.CENTER);
        p1.add(sp1, BorderLayout.EAST);
        
        bgp.add(p1, BorderLayout.CENTER);
        bgp.add(jt, BorderLayout.SOUTH);

        setVisible(true);
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        String text="";
        boolean adjust = e.getValueIsAdjusting();
        String[] mountains ={"Monkey Mountains", "Jade peak" , "eighteen mount" ,"YanMing-Shan"};

            if (!adjust) {
                JList list = (JList) e.getSource();
                
                int selections[] = list.getSelectedIndices();
                
                Object selectedValues[] = list.getSelectedValues();
                
                for (int x = 0, n = selections.length; x< n; x++) {
                    text+=selectedValues[x] + ": " + mountains[selections[x]] + "\n";
                }
            }

            jt.setText(text);
        }        
}