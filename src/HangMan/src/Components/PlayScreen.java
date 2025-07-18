package Components;
//intern:
import Data.RandomWordManager;
import Models.Difficulty;

//extern:
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        deadMan = new ImageIcon(imagePath);
        deadManLabel = new JLabel(deadMan);
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
        playScreenPanel.add(WinnerScreen.winnerScreenPanel, gbc);
        playScreenPanel.add(GameOverScreen.gameOverScreenPanel, gbc);
        WinnerScreen.DeactivateWinnerScreen();
        GameOverScreen.DeactivateGameOverScreen();

        gbc.gridy = 2;
        gbc.insets = new Insets(10,10,10,10);

        playScreenPanel.add(Scoreboard.scoreBoardPanel, gbc);

        playScreen.add(playScreenPanel);
    }

    public static void ActivatePlayScreen(Difficulty pDifficulty) {
        Keyboard.ActivateKeyboard();
        SetUpWord(pDifficulty);
        playScreen.setVisible(true);
    }

    public static void DeactivatePlayScreen() {
        playScreen.setVisible(false);
        wrongGuesses = 1;
        imagePath = "HangMan/resources/images/image_" + wrongGuesses + ".png";
        ImageIcon updatedImage = new ImageIcon(imagePath);
        deadManLabel.setIcon(updatedImage);
        deadManLabel.revalidate();
        deadManLabel.repaint();
        manPanel.revalidate();
        manPanel.repaint();
    }

    public static void OnUserInput(String pInput){
        if(!pInput.equals(null) && !pInput.equals(""))
        {
            if (word.toLowerCase().contains(pInput.toLowerCase())) {
                int correctLetters = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.toLowerCase().charAt(i) == pInput.toLowerCase().charAt(0)) {
                        disguisedWord[i] = pInput.charAt(0);
                        correctLetters++;
                    }
                }                                                                                           
                score+=correctLetters;
                Scoreboard.updateScore(score);
                playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
            }
            else{
                if(score==0){
                    wrongGuesses++;
                    imagePath = "HangMan/resources/images/image_" + wrongGuesses + ".png";
                    ImageIcon updatedImage = new ImageIcon(imagePath);
                    deadManLabel.setIcon(updatedImage);
                    deadManLabel.revalidate();
                    deadManLabel.repaint();
                    manPanel.revalidate();
                    manPanel.repaint();
                    if(wrongGuesses==8){
                        Keyboard.DeactivateKeyboard();
                        GameOverScreen.ActivateGameOverScreen();
                        disguisedWord = word.toCharArray();
                        return;
                    }
                }
                else{
                    score--;
                    Scoreboard.updateScore(score);
                }
            }
            if(!new String(disguisedWord).contains("_")){
                Keyboard.DeactivateKeyboard();
                WinnerScreen.ActivateWinnerScreen();
            }
        }
    }

    public static void ResetPlayScreen(){
        Keyboard.ResetKeyboard();
        score = 0;
        Scoreboard.updateScore(score);
    }

    private static void SetUpWord(Difficulty pDifficulty){
        wordList = RandomWordManager.getRandomWord(pDifficulty);
        String wordString = wordList.get(random.nextInt(0,99));
        word = wordString;
        disguisedWord = new char[wordString.length()];
        for (int i = 0; i < wordString.length(); i++)
        {
            disguisedWord[i]='_';
        }

        playField.setText(new String(disguisedWord).replaceAll(".(?!$)", "$0 "));
    }

    private static int wrongGuesses=1;
    private static Random random = new Random();
    private static JPanel manPanel = new JPanel();
    private static JFrame playScreen = new JFrame("Play Screen");
    private static JPanel playScreenPanel = new JPanel();
    private static List<String> wordList = new ArrayList<>();
    private static JLabel playField = new JLabel();
    private static char[] disguisedWord = new char[]{};
    private static String word;
    private static String imagePath = "HangMan/resources/images/image_" + wrongGuesses + ".png";
    private static ImageIcon deadMan;
    private static JLabel deadManLabel;
    private static int score = 0;

}
