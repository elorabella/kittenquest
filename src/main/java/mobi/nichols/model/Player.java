package mobi.nichols.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_ITEMS_IN_BAG = 100;

    private String name;
    private List<Object> bag = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToBag(Object item) {
        this.bag.add(item);
    }

    public Object removeFromBag(Object item) {
        this.bag.remove(item);
        return item;
    }
}