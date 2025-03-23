package Components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Keyboard {
    private static String letters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";

    public static JPanel keyboard = new JPanel();

    public static void SetUpKeyboard(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        keyboard.setLayout(new GridBagLayout());
        keyboard.setBackground(new Color(78, 67, 214));
        gbc.gridy = 0;
        int xPos = 0;

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        for(char letter : letters.toCharArray()){
            if (letter == 'J') {
                gbc.gridy++;
                xPos = 0;
            }
            if(letter =='S'){
                gbc.gridy++;
                xPos=0;
                xPos++;
            }

            gbc.gridx = xPos++;
            JButton button = new JButton(String.valueOf(letter));

            button.setPreferredSize(new Dimension(35, 35));
            //button.setMinimumSize(new Dimension(50, 50));
            //button.setMaximumSize(new Dimension(50, 50));

            button.setBackground(new Color(155, 12, 190));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);

            button.setBorder(border); // Schwarzer Rand mit einer Dicke von 1 Pixel

            keyboard.add(button,gbc);
        }
    }
}
