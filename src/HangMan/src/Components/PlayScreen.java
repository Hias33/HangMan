package Components;
import Data.RandomWordManager;
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

        playScreen.setSize(600,400);
        playScreen.getContentPane().setBackground(new Color(78, 67, 214));
        playScreenPanel.setBackground(new Color(78, 67, 214));
        playScreen.setLayout(new GridBagLayout());

        playScreenPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 4;

        gbc.gridy = 0;
        playField.setFont(new Font("Arial", Font.BOLD, 35));
        playScreenPanel.add(playField, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(40,10,10,10);
        input.setPreferredSize(new Dimension(50, 20));
        input.setDocument(inputSetting);
        playScreenPanel.add(Keyboard.keyboard, gbc);
        //playScreenPanel.add(input, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(10,10,10,10);
        confirm.addActionListener(onUserInput);
        //playScreenPanel.add(confirm, gbc);

        playScreen.add(playScreenPanel);
    }

    public static void ActivatePlayScreen() {
        SetUpWord();
        playScreen.setVisible(true);
    }

    public static void DeactivatePlayScreen() {
        playScreen.setVisible(false);
    }

    public static void OnUserInput(String pInput){
        if(!pInput.equals(null) && !pInput.equals(""))
        {
            if (word.contains(pInput.toLowerCase())) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == pInput.toLowerCase().charAt(0)) {
                        disguisedWord[i] = pInput.charAt(0);
                    }
                }
                playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
            }
            input.setText("");

            if(!new String(disguisedWord).contains("_")){
                //DeactivatePlayScreen();
                //WinnerScreen.ActivateWinnerScreen();
            }
        }
    }

    private static void SetUpWord(){
        wordList = RandomWordManager.getRandomWord();
        String wordString = wordList.get(0);
        word = wordString;
        disguisedWord = new char[wordString.length()];
        for (int i = 0; i < wordString.length(); i++)
        {
            disguisedWord[i]='_';
        }

        playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
    }

    private static JFrame playScreen = new JFrame("Play Screen");
    private static JPanel playScreenPanel = new JPanel();
    private static List<String> wordList = new ArrayList<>();
    private static JLabel playField = new JLabel();
    private static char[] disguisedWord = new char[]{};
    private static JTextArea input = new JTextArea();
    private static JButton confirm = new JButton("Confirm");
    private static String word;
    private static JLabel winnerLabel = new JLabel("YOU WON!!!");
    private static ImageIcon hangManImage = new ImageIcon();

    private static AbstractAction onUserInput = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = input.getText();
            if(!userInput.equals(null) && !userInput.equals(""))
            {
                if (word.contains(userInput)) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == userInput.charAt(0)) {
                            disguisedWord[i] = userInput.charAt(0);
                        }
                    }
                    playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
                }
                input.setText("");

                if(!new String(disguisedWord).contains("_")){
                    DeactivatePlayScreen();
                    WinnerScreen.ActivateWinnerScreen();
                }
            }
        }
    };

    private static PlainDocument inputSetting = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (getLength() < 1) {
                super.insertString(offs, str, a);
            }
        }
    };

}