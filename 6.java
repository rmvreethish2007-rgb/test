import javax.swing.*;

public class CounterMin {
    public static void main(String[] args) {

        JFrame f = new JFrame("Counter");
        JTextArea ta = new JTextArea();
        JButton b = new JButton("Count");
        JLabel l = new JLabel( "Words: 0  Characters: 0");

        f.setLayout(null);
        f.setSize(450,450);

        ta.setBounds(10, 10, 320, 150);
        b.setBounds(10, 170, 100, 25);
        l.setBounds(120, 170, 200, 25);

        f.add(ta); 
        f.add(b); 
        f.add(l);

        b.addActionListener(e -> {
            String t = ta.getText();
            int c = t.length();
            int w = t.trim().isEmpty()?0:t.trim().split("\\s+").length;
            l.setText("Words:"+w+" Chars:"+c);
        });

        f.setVisible(true);
    }
}
