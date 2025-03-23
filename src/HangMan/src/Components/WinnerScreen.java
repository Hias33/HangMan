package Components;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WinnerScreen {
    private static JFrame winnerScreen = new JFrame();
    private static JPanel winnerPanel = new JPanel();
    private static JLabel winnerText = new JLabel("We have a winner!\n Do you want to play again?");
    private static JButton playAgainButton = new JButton("Start again");

    private static AbstractAction startAgainAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DeactivateWinnerScreen();
            ChooseDifficultySite.ActivateDifficultySite();
        }
    };

    public static void SetUpWinnerScreen(){
        winnerScreen.setSize(400,400);
        winnerPanel.add(winnerText);

        playAgainButton.addActionListener(startAgainAction);
        winnerPanel.add(playAgainButton);

        winnerScreen.add(winnerPanel);
    }

    public static void ActivateWinnerScreen(){
        winnerScreen.setVisible(true);
    }

    public static void DeactivateWinnerScreen(){
        winnerScreen.setVisible(false);
    }
}
