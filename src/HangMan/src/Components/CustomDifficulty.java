package Components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CustomDifficulty {
    static JFrame customDifficultyFrame = new JFrame("Custom Difficulty");
    static JPanel customDifficultyPanel = new JPanel();

    static AbstractAction getBackAction = new AbstractAction("Back") {
        @Override
        public void actionPerformed(ActionEvent e) {
            DeactivateCustomDifficulty();
            ChooseDifficultySite.ActivateDifficultySite();
        }
    };

    public static void SetUpCustomDifficulty() {
        customDifficultyFrame.setSize(600,400);

        JLabel difficultyLabel = new JLabel("Custom Difficulty");
        customDifficultyPanel.add(difficultyLabel);

        JButton getBackButton = new JButton("Get Back");
        getBackButton.addActionListener(getBackAction);
        customDifficultyPanel.add(getBackButton);

        customDifficultyFrame.add(customDifficultyPanel);
    }

    public static void ActivateCustomDifficulty() {
        customDifficultyFrame.setVisible(true);
    }

    public static void DeactivateCustomDifficulty() {
        customDifficultyFrame.setVisible(false);
    }
}
