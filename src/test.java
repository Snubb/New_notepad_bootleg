import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame( "Exempel");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(30, 30);
        JButton button = new JButton("I am a button.");
        frame.add(panel);
        panel.add(textArea);
        panel.add(button);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
