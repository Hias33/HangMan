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
        playScreen.setSize(400,400);
        JLabel title = new JLabel("Play Screen");
        playScreenPanel.add(title);

        playScreenPanel.add(playField);

        input.setPreferredSize(new Dimension(50, 20));
        input.setDocument(inputSetting);
        playScreenPanel.add(input);

        confirm.addActionListener(onUserInput);
        playScreenPanel.add(confirm);

        playScreen.add(playScreenPanel);
    }

    public static void ActivatePlayScreen() {
        SetUpWord();
        playScreen.setVisible(true);
    }

    public static void DeactivatePlayScreen() {
        playScreen.setVisible(false);
    }

    private static void SetUpWord(){
        wordList = RandomWordManager.getRandomWord();
        String wordString = wordList.get(0);
        word = wordString;
        disguisedWord = new char[wordString.length()];
        for (int i = 0; i < wordString.length(); i++)
        {
            disguisedWord[i]='.';
        }

        playField.setText(new String(disguisedWord));
    }

    private static JFrame playScreen = new JFrame("Play Screen");
    private static JPanel playScreenPanel = new JPanel();
    private static List<String> wordList = new ArrayList<>();
    private static JLabel playField = new JLabel();
    private static char[] disguisedWord = new char[]{};
    private static JTextArea input = new JTextArea();
    private static JButton confirm = new JButton("Confirm");
    private static String word;

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
                    playField.setText(new String(disguisedWord));
                }
                input.setText("");
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