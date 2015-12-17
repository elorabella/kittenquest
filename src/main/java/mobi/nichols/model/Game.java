package mobi.nichols.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private List<Item> kittens = new ArrayList<>();
    private Cell startingCell;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getStartingCell() {
        return startingCell;
    }

    public void setStartingCell(Cell startingCell) {
        this.startingCell = startingCell;
    }

    public void addKitten(Kitten kitten) {
        this.kittens.add(kitten);
    }

    public List<Item> getKittens() {
        return this.kittens;
    }
}
