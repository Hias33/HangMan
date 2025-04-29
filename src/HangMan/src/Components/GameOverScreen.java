package Components;
//extern:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameOverScreen {

    public static JPanel gameOverScreenPanel = new JPanel();

    public static void SetUpGameOverScreen() {
        GridBagConstraints gbc = new GridBagConstraints();

        gameOverScreenPanel.setBackground(new Color(78, 67, 214));
        gameOverScreenPanel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel gameOverLabel = new JLabel("Game Over!");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 50));
        gameOverLabel.setForeground(new Color(255, 69, 69));
        gameOverScreenPanel.add(gameOverLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(20, 10, 10, 10);


        playAgainButton.setFont(new Font("Arial", Font.BOLD, 20));
        playAgainButton.setBackground(new Color(255, 69, 69));
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.addActionListener(playAgainAction);
        gameOverScreenPanel.add(playAgainButton, gbc);
    }

    public static void ActivateGameOverScreen() {
        gameOverScreenPanel.setVisible(true);
    }

    public static void DeactivateGameOverScreen() {
        gameOverScreenPanel.setVisible(false);
    }

    private static AbstractAction playAgainAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.DeactivatePlayScreen();
            PlayScreen.ResetPlayScreen();
            ChooseDifficultySite.ActivateDifficultySite();
            DeactivateGameOverScreen();
        }
    };

    private static JButton playAgainButton = new JButton("Play Again");
}
