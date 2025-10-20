package Lesson_3.Park;

public class Main {
    public static void main(String[] args) {
        Park park = new Park();

        park.addAttraction("Американские горки", "10:00 - 18:00", 300);
        park.addAttraction("Карусель", "09:00 - 20:00", 150);
        park.addAttraction("Лабиринт", "11:00 - 17:00", 200);
        park.addAttraction("Комната страха", "11:00 - 17:00", 250);
        park.showAttractions();
    }
}
