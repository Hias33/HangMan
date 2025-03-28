package Components;
import Data.RandomWordManager;
import Models.Difficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ChooseDifficultySite {
    static JFrame difficultySite = new JFrame("Difficulty Site");
    static JPanel panel = new JPanel();

    static AbstractAction easyAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.ActivatePlayScreen(Difficulty.Easy);
            difficultySite.setVisible(false);
        }
    };

    static AbstractAction mediumAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.ActivatePlayScreen(Difficulty.Medium);
            difficultySite.setVisible(false);
        }
    };

    static AbstractAction hardAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.ActivatePlayScreen(Difficulty.Hard);
            difficultySite.setVisible(false);
        }
    };

    static AbstractAction customDifficultyAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CustomDifficulty.ActivateCustomDifficulty();
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
        easy.setBackground(Color.GREEN);
        gbc.gridy = 1;
        easy.addActionListener(easyAction);
        easy.setFocusPainted(false);
        panel.add(easy, gbc);

        JButton medium = new JButton("Medium");
        medium.setBackground(Color.ORANGE);
        gbc.gridy = 2;
        medium.addActionListener(mediumAction);
        medium.setFocusPainted(false);
        panel.add(medium, gbc);

        JButton hard = new JButton("Hard");
        hard.setBackground(Color.RED);
        gbc.gridy = 3;
        hard.addActionListener(hardAction);
        hard.setFocusPainted(false);
        panel.add(hard, gbc);

        JButton custom = new JButton("Custom");
        custom.setBackground(Color.MAGENTA);
        custom.addActionListener(customDifficultyAction);
        gbc.gridy = 4;
        custom.setFocusPainted(false);
        panel.add(custom, gbc);

        difficultySite.add(panel);

    }

    public static void ActivateDifficultySite(){
        difficultySite.setVisible(true);
    }

    public static void DeactivateDifficultySite(){
        difficultySite.setVisible(false);
    }
}
