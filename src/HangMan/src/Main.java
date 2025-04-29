import Components.*;

public class Main {
    public static void main(String[] args) {
        SetUpSites();
        ChooseDifficultySite.ActivateDifficultySite();
    }

    private static void SetUpSites(){
        ChooseDifficultySite.SetUpDifficultySite();
        PlayScreen.SetUpPlayScreen();
        Keyboard.SetUpKeyboard();
        Scoreboard.SetUpScoreBoard();
        WinnerScreen.SetUpWinnerScreen();
        GameOverScreen.SetUpGameOverScreen();
    }
}
