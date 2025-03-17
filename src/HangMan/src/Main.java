import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("GUI Screen");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 400);

        // Hauptpanel mit GridBagLayout für saubere Anordnung
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Immer in der ersten Spalte
        gbc.insets = new Insets(10, 10, 10, 10); // Abstand zwischen den Elementen

        // Überschrift oben mittig
        JLabel text = new JLabel("Welcome! Choose your difficulty!", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 0; // Erste Zeile
        panel.add(text, gbc);

        // Buttons mit Hintergrundfarben und korrekter Anordnung
        JButton easy = new JButton("Easy");
        easy.setBackground(Color.GREEN);
        gbc.gridy = 1; // Zweite Zeile
        panel.add(easy, gbc);

        JButton medium = new JButton("Medium");
        medium.setBackground(Color.ORANGE);
        gbc.gridy = 2;
        panel.add(medium, gbc);

        JButton hard = new JButton("Hard");
        hard.setBackground(Color.RED);
        gbc.gridy = 3;
        panel.add(hard, gbc);

        JButton custom = new JButton("Custom");
        custom.setBackground(Color.MAGENTA);
        gbc.gridy = 4;
        panel.add(custom, gbc);

        // Action für den "Easy" Button
        easy.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame easyScreen = new JFrame("Easy!");
                easyScreen.setSize(400, 400);
                JPanel easyJPanel = new JPanel();
                JLabel easyLabel = new JLabel("Easy!!!");
                easyJPanel.add(easyLabel);
                easyScreen.add(easyJPanel);
                easyScreen.setVisible(true);
                jframe.setVisible(false);
            }
        });

        jframe.add(panel);
        jframe.setVisible(true);
    }
}
