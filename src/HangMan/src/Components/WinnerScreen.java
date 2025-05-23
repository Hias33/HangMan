package Components;
//extern:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WinnerScreen {

    public static JPanel winnerScreenPanel = new JPanel();

    public static void SetUpWinnerScreen() {
        GridBagConstraints gbc = new GridBagConstraints();

        winnerScreenPanel.setBackground(new Color(78, 67, 214));

        winnerScreenPanel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel victoryLabel = new JLabel("Victory!");
        victoryLabel.setFont(new Font("Arial", Font.BOLD, 50));
        victoryLabel.setForeground(new Color(255, 215, 0));
        winnerScreenPanel.add(victoryLabel, gbc);


        gbc.gridy = 1;
        gbc.insets = new Insets(20, 10, 10, 10);

        playAgainButton.setFont(new Font("Arial", Font.BOLD, 20));
        playAgainButton.setBackground(new Color(255, 215, 0));
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.addActionListener(playAgainAction);
        winnerScreenPanel.add(playAgainButton, gbc);
    }

    public static void ActivateWinnerScreen() {
        winnerScreenPanel.setVisible(true);
    }

    public static void DeactivateWinnerScreen() {
        winnerScreenPanel.setVisible(false);
    }

    private static AbstractAction playAgainAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.DeactivatePlayScreen();
            PlayScreen.ResetPlayScreen();
            DeactivateWinnerScreen();
            ChooseDifficultySite.ActivateDifficultySite();
        }
    };

    private static JButton playAgainButton = new JButton("Play Again");
}
