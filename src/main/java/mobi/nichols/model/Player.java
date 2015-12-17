package mobi.nichols.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_ITEMS_IN_BAG = 100;

    private String name;
    private List<Item> bag = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToBag(Item item) {
        this.bag.add(item);
    }

    public Object removeFromBag(Item item) {
        this.bag.remove(item);
        return item;
    }
}