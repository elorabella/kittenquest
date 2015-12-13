package mobi.nichols.model;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Function;

public class Game {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void start() {
        askPlayerForName();
        getPromptInput();
    }

    public void quit() {
        System.exit(0);
    }

    public void askPlayerForName() {
        this.player = new Player();
        System.out.print("Please enter your name: ");
        this.player.setName(scanner.nextLine());
        System.out.println();
        System.out.println("Thank you, " + this.player.getName() + "!");
    }

    public void getPromptInput() {
        waitForInput(new Function<String, String>() {
            @Override
            public String apply(String s) {
                switch (s.toUpperCase()) {
                    case "QUIT":
                        quit();
                        break;
                    default:
                        System.out.println(s);
                        getPromptInput();
                        break;
                }
                return null;
            }
        });
    }

    public void waitForInput(Function<String, String> callback) {
        printPrompt();
        callback.apply(scanner.nextLine());
    }

    public void printPrompt() {
        System.out.println();
        System.out.print("$> ");
    }

    public void printSplash() throws Exception {
        InputStream input = new BufferedInputStream(getClass().getResourceAsStream("/splash.txt"));
        byte[] buffer = new byte[8192];

        try {
            for (int length = 0; (length = input.read(buffer)) != -1;) {
                System.out.write(buffer, 0, length);
            }
        } finally {
            input.close();
        }
    }
}
