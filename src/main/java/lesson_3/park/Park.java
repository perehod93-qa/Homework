package lesson_3.park;

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
}