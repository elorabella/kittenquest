package mobi.nichols;

import mobi.nichols.controllers.GameController;
import mobi.nichols.model.Game;

public class KittenQuest {
    public static void main(String[] arg) throws Exception {
        Game game = new Game();
        GameController gameController = new GameController(game);
        gameController.printSplash();
        gameController.start();
    }
}
