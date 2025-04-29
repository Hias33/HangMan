package Components;
//extern:
import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {
    public static JPanel scoreBoardPanel = new JPanel();
    private static JLabel scoreLabel;
    private static JLabel titleLabel = new JLabel("Score:");

    public static void SetUpScoreBoard(){
        scoreBoardPanel.setLayout(new BoxLayout(scoreBoardPanel, BoxLayout.Y_AXIS));
        scoreBoardPanel.setBackground(new Color(78, 67, 214));

        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        scoreLabel = new JLabel("0");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setAlignmentX(CENTER_ALIGNMENT);

        scoreBoardPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        scoreBoardPanel.add(titleLabel);
        scoreBoardPanel.add(scoreLabel);
    }

    public static void updateScore(int score) {
        scoreLabel.setText(String.valueOf(score));
    }
}
