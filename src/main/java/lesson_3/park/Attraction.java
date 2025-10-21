package lesson_3.park;

import lesson_3.Item;

public class Attraction extends Item {
    private String workingHours;
    private double cost;

    public Attraction(String name, String workingHours, double cost) {
        super(name);
        this.workingHours = workingHours;
        this.cost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Аттракцион: " + name);
        System.out.println("Время работы: " + workingHours);
        System.out.println("Стоимость: " + cost);
        System.out.println("---------------------------");
    }
}