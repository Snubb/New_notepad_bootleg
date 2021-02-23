import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUIManager {

    public GUIManager() {
        clear.addActionListener(new clearText());

        Copy.addActionListener(new copyText());

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                // Öppna fil för läsning
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filename;
                if (result == JFileChooser.APPROVE_OPTION) {
                    filename = fc.getSelectedFile().getAbsolutePath();
                } else {
                    filename = "exempel.txt";
                }

                FileReader fr = null;
                try {
                    fr = new FileReader(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader inFile = new BufferedReader(fr);

                //Öppna fil för skrivning
                String filename2 = filename + "Copy";
                FileWriter fw = null;
                try {
                    fw = new FileWriter(filename2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter outFile = new PrintWriter(bw);

                // Läs in filen
                String line;
                try {
                    for (int i = 0; i < textArea1.toString().length(); i++) {
                        outFile.println(textArea1);
                    }

                    inFile.close();
                    outFile.flush();
                    outFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        openButton.addActionListener(new openText());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIManager");
        frame.setContentPane(new GUIManager().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTextArea textArea1;
    private JPanel panel1;
    private JButton clear;
    private JButton Copy;
    private JButton saveButton;
    private JButton openButton;

    private class openText implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Öppna fil för läsning
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);
            String filename;
            if (result == JFileChooser.APPROVE_OPTION) {
                filename = fc.getSelectedFile().getAbsolutePath();
            } else {
                filename = "exempel.txt";
            }

            FileReader fr = null;
            try {
                fr = new FileReader(filename);
            } catch (FileNotFoundException a) {
                a.printStackTrace();
            }
            BufferedReader inFile = new BufferedReader(fr);

            // Läs in filen
            String line;
            try {
                while ((line = inFile.readLine()) != null) {
                    textArea1.setText("");
                    textArea1.append(line);
                }
                inFile.close();
            } catch (IOException a) {
                a.printStackTrace();
            }
        }
    }

    private class clearText implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea1.setText("");
        }
    }

    private class copyText implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea1.append("\n" + textArea1.getText());
            System.out.println(textArea1.getText());
        }
    }
}
