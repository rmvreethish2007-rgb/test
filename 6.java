import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing_nof extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton countButton;
    JLabel resultLabel;

    swing_nof() {
        setTitle("Word and Character Counter");
        setSize(400, 300);
        setLayout(new FlowLayout());

        textArea = new JTextArea(5, 30);
        countButton = new JButton("Count");
        resultLabel = new JLabel("Words: 0 | Characters: 0");

        add(new JScrollPane(textArea));
        add(countButton);
        add(resultLabel);

        countButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText().trim();

        int charCount = text.length();
        int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;

        resultLabel.setText("Words: " + wordCount + " | Characters: " + charCount);
    }

    public static void main(String[] args) {
        new swing_nof();
    }
}
