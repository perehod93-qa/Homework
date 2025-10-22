package lesson_3.park;

import lesson_3.Item;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingHours, double cost) {
        attractions.add(new Attraction(name, workingHours, cost));
    }

    public void showAttractions() {
        System.out.println("Парк: " + parkName);
        for (Attraction attraction : attractions) {
            attraction.displayInfo();
        }
    }

    public String getParkName() {
        return parkName;
    }

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
}