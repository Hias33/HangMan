package Components;
import Data.RandomWordManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayScreen {
    static JFrame playScreen = new JFrame("Play Screen");
    static JPanel playScreenPanel = new JPanel();

    public static void SetUpPlayScreen() {
        playScreen.setSize(400,400);
        JLabel title = new JLabel("Play Screen");
        playScreenPanel.add(title);
        playScreen.add(playScreenPanel);
    }

    public static void ActivatePlayScreen() {
        playScreen.setVisible(true);
        RandomWordManager.getRandomWord();
    }

    public static void DeactivatePlayScreen() {
        playScreen.setVisible(false);
    }
}