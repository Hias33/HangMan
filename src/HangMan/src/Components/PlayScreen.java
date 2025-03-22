package Components;
import Data.RandomWordManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class PlayScreen {
    static JFrame playScreen = new JFrame("Play Screen");
    static JPanel playScreenPanel = new JPanel();
    static List<String> wordList = new ArrayList<>();
    static JLabel word = new JLabel();

    public static void SetUpPlayScreen() {
        playScreen.setSize(400,400);
        JLabel title = new JLabel("Play Screen");
        playScreenPanel.add(title);

        playScreenPanel.add(word);
        playScreen.add(playScreenPanel);
    }

    public static void ActivatePlayScreen() {
        playScreen.setVisible(true);
    }

    public static void DeactivatePlayScreen() {
        playScreen.setVisible(false);
    }

    private static void SetUpWord(){
        wordList = RandomWordManager.getRandomWord();
        word.setText(wordList.get(0));
    }
}