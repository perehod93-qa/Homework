package Lesson_3.Park;

import java.util.ArrayList;
import java.util.List;

public class Park {

    public class Attraction {
        String name;
        String workingHours;
        double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
            System.out.println("---------------------------");
        }
    }

    private List<Attraction> attractions = new ArrayList<>();

    public void addAttraction(String name, String workingHours, double cost) {
        attractions.add(new Attraction(name, workingHours, cost));
    }

    public void showAttractions() {
        for (Attraction attraction : attractions) {
            attraction.displayInfo();
        }
    }
}
