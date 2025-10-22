package lesson_3.park;

public class ParkMain {
    public static void main(String[] args) {
        Park amusementPark = new Park("Весёлый городок");

        amusementPark.addAttraction("Колесо обозрения", "10:00 - 22:00", 300);
        amusementPark.addAttraction("Американские горки", "11:00 - 21:00", 500);
        amusementPark.addAttraction("Комната страха", "14:00 - 23:00", 400);

        Park pokatushkiPark = new Park("Покатушки");

        pokatushkiPark.addAttraction("Машинки", "10:00 - 22:00", 200);
        pokatushkiPark.addAttraction("Американские горки", "11:00 - 21:00", 500);
        pokatushkiPark.addAttraction("Комната страха", "14:00 - 23:00", 400);
        pokatushkiPark.addAttraction("Карусель", "10:00 - 22:00", 250);


        amusementPark.showAttractions();
        System.out.println();
        pokatushkiPark.showAttractions();
    }
}