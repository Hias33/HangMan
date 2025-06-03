package Components;
//intern:
import Models.Difficulty;

//extern:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseDifficultySite {
    static JFrame difficultySite = new JFrame("Difficulty Site");
    static JPanel panel = new JPanel();

    static AbstractAction easyAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.ActivatePlayScreen(Difficulty.Easy);
            DeactivateDifficultySite();
        }
    };

    static AbstractAction mediumAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.ActivatePlayScreen(Difficulty.Medium);
            DeactivateDifficultySite();
        }
    };

    static AbstractAction hardAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.ActivatePlayScreen(Difficulty.Hard);
            DeactivateDifficultySite();
        }
    };

    public static void SetUpDifficultySite(){
        difficultySite.setSize(600, 400);
        difficultySite.setBackground(new Color(78, 67, 214));

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(78, 67, 214));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        JLabel text = new JLabel("Welcome! Choose your difficulty!", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 0;
        panel.add(text, gbc);

        JButton easy = new JButton("Easy");
        easy.setBackground(new Color(102, 205, 102));
        gbc.gridy = 1;
        easy.addActionListener(easyAction);
        easy.setFocusPainted(false);
        easy.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(easy, gbc);

        JButton medium = new JButton("Medium");
        medium.setBackground(new Color(244, 164, 96));
        gbc.gridy = 2;
        medium.addActionListener(mediumAction);
        medium.setFocusPainted(false);
        medium.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(medium, gbc);

        JButton hard = new JButton("Hard");
        hard.setBackground(new Color(178, 34, 34));
        gbc.gridy = 3;
        hard.addActionListener(hardAction);
        hard.setFocusPainted(false);
        hard.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(hard, gbc);

        difficultySite.add(panel);

    }

    public static void ActivateDifficultySite(){
        difficultySite.setVisible(true);
    }

    public static void DeactivateDifficultySite(){
        difficultySite.setVisible(false);
    }
}
