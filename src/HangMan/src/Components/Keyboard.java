package Components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Keyboard {
    private static String letters = "ABCDEFGHIJKLMNOPQRSTUWVXYZ";

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
            if (letter == 'J'||letter =='S') {
                gbc.gridy++;
                xPos = 0;
            }

            gbc.gridx = xPos++;
            JButton button = new JButton(String.valueOf(letter));

            button.setPreferredSize(new Dimension(35, 35));

            button.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PlayScreen.OnUserInput(String.valueOf(letter));
                    button.setEnabled(false);
                    button.setBackground(new Color(95, 29, 111));
                }
            });

            button.setBackground(new Color(155, 12, 190));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setBorder(border);

            keyboard.add(button,gbc);
        }
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        JButton getBack = new JButton();
        getBack.setText("Back!");
        getBack.setPreferredSize(new Dimension(40, 35));
        getBack.setBackground(Color.RED);
        getBack.setForeground(Color.WHITE);
        getBack.setFocusPainted(false);
        getBack.addActionListener(backAction);
        getBack.setBorder(border);
        keyboard.add(getBack,gbc);

    }
    
    static AbstractAction backAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayScreen.DeactivatePlayScreen();
            ChooseDifficultySite.ActivateDifficultySite();
        }
    };
}
