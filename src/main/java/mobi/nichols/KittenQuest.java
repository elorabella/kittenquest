package mobi.nichols;

import mobi.nichols.model.Game;

public class KittenQuest {
    public static void main(String[] arg) throws Exception {
        Game game = new Game();
        game.printSplash();
        game.start();
    }
}
