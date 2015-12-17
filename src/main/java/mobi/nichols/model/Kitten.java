package mobi.nichols.model;

public class Kitten implements Item {
    private static final String TYPE = "Kitten";
    private String name;
    private String description;

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
