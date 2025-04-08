package Components;
import Data.RandomWordManager;
import Models.Difficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.text.*;


public class PlayScreen {
    public static void SetUpPlayScreen() {
        GridBagConstraints gbc = new GridBagConstraints();

        playScreen.setSize(800,500);
        playScreen.getContentPane().setBackground(new Color(78, 67, 214));
        playScreenPanel.setBackground(new Color(78, 67, 214));
        playScreen.setLayout(new GridBagLayout());

        playScreenPanel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 0);
        ImageIcon deadMan = new ImageIcon("C:\\Users\\Matthe2209\\IdeaProjects\\pictures\\Design ohne Titel.png");
        JLabel deadManLabel = new JLabel(deadMan);
        manPanel.add(deadManLabel);
        manPanel.setOpaque(false);
        playScreen.add(manPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;

        gbc.gridy = 0;
        playField.setFont(new Font("Arial", Font.BOLD, 35));
        playScreenPanel.add(playField, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(40,10,10,10);
        playScreenPanel.add(Keyboard.keyboard, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(10,10,10,10);

        playScreen.add(playScreenPanel);
    }

    public static void ActivatePlayScreen(Difficulty pDifficulty) {
        SetUpWord();
        playScreen.setVisible(true);
    }

    public static void DeactivatePlayScreen() {
        playScreen.setVisible(false);
    }

    public static void OnUserInput(String pInput){
        if(!pInput.equals(null) && !pInput.equals(""))
        {
            if (word.toLowerCase().contains(pInput.toLowerCase())) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.toLowerCase().charAt(i) == pInput.toLowerCase().charAt(0)) {
                        disguisedWord[i] = pInput.charAt(0);
                    }
                }
                playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
            }
            if(!new String(disguisedWord).contains("_")){

            }
        }
    }

    private static void SetUpWord(){
        //wordList = RandomWordManager.getRandomWord();
        wordList = List.of(
                "Baum", "Wolke", "Straße", "Fahrrad", "Apfel",
                "Hund", "Buch", "Fenster", "Tisch", "Lampe"
        );
        String wordString = wordList.get(0);
        word = wordString;
        disguisedWord = new char[wordString.length()];
        for (int i = 0; i < wordString.length(); i++)
        {
            disguisedWord[i]='_';
        }

        playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
    }

    private static JPanel manPanel = new JPanel();
    private static JFrame playScreen = new JFrame("Play Screen");
    private static JPanel playScreenPanel = new JPanel();
    private static List<String> wordList = new ArrayList<>();
    private static JLabel playField = new JLabel();
    private static char[] disguisedWord = new char[]{};
    private static String word;



    private static PlainDocument inputSetting = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (getLength() < 1) {
                super.insertString(offs, str, a);
            }
        }
    };

}