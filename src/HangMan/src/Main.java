import Components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        SetUpSites();
        ChooseDifficultySite.ActivateDifficultySite();
    }

    private static void SetUpSites(){
        ChooseDifficultySite.SetUpDifficultySite();
        PlayScreen.SetUpPlayScreen();
        CustomDifficulty.SetUpCustomDifficulty();
        WinnerScreen.SetUpWinnerScreen();
        Keyboard.SetUpKeyboard();
    }
}
