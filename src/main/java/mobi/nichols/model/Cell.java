package mobi.nichols.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private Cell north;
    private Cell south;
    private Cell east;
    private Cell west;
    private String description;
    private boolean isStartingCell = false;
    private List<Item> itemsInCell = new ArrayList<>();

    public Cell() {

    }

    public boolean isStartingCell() {
        return isStartingCell;
    }

    public void setStartingCell(boolean startingCell) {
        isStartingCell = startingCell;
    }

    public Cell getNorth() {
        return north;
    }

    public void setNorth(Cell north) {
        this.north = north;
    }

    public Cell getSouth() {
        return south;
    }

    public void setSouth(Cell south) {
        this.south = south;
    }

    public Cell getEast() {
        return east;
    }

    public void setEast(Cell east) {
        this.east = east;
    }

    public Cell getWest() {
        return west;
    }

    public void setWest(Cell west) {
        this.west = west;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addItemToCell(Item item) {
        this.itemsInCell.add(item);
    }

    public List<Item> getItemsInCell() {
        return this.itemsInCell;
    }
}
