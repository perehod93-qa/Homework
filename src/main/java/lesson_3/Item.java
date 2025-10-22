package lesson_3;

public abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void displayInfo();

    public String getName() {
        return name;
    }
}
