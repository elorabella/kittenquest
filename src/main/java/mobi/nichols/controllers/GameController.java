package mobi.nichols.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import mobi.nichols.model.Game;
import mobi.nichols.model.Item;
import mobi.nichols.model.Kitten;
import mobi.nichols.model.Player;
import mobi.nichols.model.yaml.KittensYaml;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class GameController {
    private Game game;
    private Scanner scanner = new Scanner(System.in);

    public GameController(Game game) {
        this.game = game;
    }

    public void start() {
        try {
            askPlayerForName();
            generateGameGrid();
            getPromptInput();
        } catch (Exception ex) {
            System.out.println("An unhandled exception has occurred: " + ex.getMessage());
            System.out.println("Quitting...");
            quit();
        }
    }

    public void quit() {
        System.exit(0);
    }

    public void generateGameGrid() throws Exception {
        generateKittens();

        // TODO: number of cells is 3 times number of kittens
        // TODO: generate cells and place kittens
    }

    public int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void generateKittens() throws Exception {
        System.out.print("Generating kittens...");
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        KittensYaml kittensYaml = mapper.readValue(getClass().getResourceAsStream("/kittens.yaml"), KittensYaml.class);

        int max = 10;
        if (kittensYaml.getKittens().size() < 10) {
            max = kittensYaml.getKittens().size();
        }
        int numKittens = getRandomInt(1, max);
        for (int i = 0; i < numKittens; i++) {
            int randomItem = getRandomInt(0, kittensYaml.getKittens().size() - 1);
            Kitten kitten = kittensYaml.getKittens().get(randomItem);
            while (this.game.getKittens().contains(kitten)) {
                randomItem = getRandomInt(0, kittensYaml.getKittens().size() - 1);
                kitten = kittensYaml.getKittens().get(randomItem);
            }
            this.game.addKitten(kitten);
        }
        System.out.println("done.");
        System.out.println("Number of kittens lost: " + this.game.getKittens().size());
    }

    public void askPlayerForName() {
        this.game.setPlayer(new Player());
        System.out.print("Please enter your name: ");
        this.game.getPlayer().setName(scanner.nextLine());
        System.out.println();
        System.out.println("Thank you, " + this.game.getPlayer().getName() + "!");
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
