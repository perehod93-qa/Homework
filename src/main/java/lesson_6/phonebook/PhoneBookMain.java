package lesson_6.phonebook;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "И.И.", "+7-999-111-22-33");
        phoneBook.add("Петров", "П.П.", "+7-999-222-33-44");
        phoneBook.add("Иванов", "А.С.", "+7-999-555-66-25");
        phoneBook.add("Сидоров", "А.С.", "+7-999-789-66-77");
        phoneBook.add("Иванов", "И.Д.", "+7-999-555-66-77");
        phoneBook.add("Попов", "М.Л.", "+7-999-555-78-77");
        phoneBook.add("Смирнов", "Р.В.", "+7-999-456-78-77");

        System.out.println("=== Все записи ===");
        phoneBook.printAll();

        System.out.println("\n=== Поиск телефонов по фамилии Иванов ===");
        phoneBook.get("Иванов");

        System.out.println("\n=== Поиск телефонов по фамилии Сидоров ===");
        phoneBook.get("Сидоров");

        System.out.println("\n=== Поиск телефонов по фамилии Свободны ===");
        phoneBook.get("Свободны");
    }
}