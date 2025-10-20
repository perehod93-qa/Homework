package Lesson_3.Product;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Apple iPhone 15", "15.09.2024",
                "Apple Inc.", "USA", 9999, false);
        productsArray[2] = new Product("Xiaomi Mi 13", "10.03.2024",
                "Xiaomi", "China", 4999, false);
        productsArray[3] = new Product("Sony WH-1000XM5", "20.07.2023",
                "Sony", "Japan", 2999, true);
        productsArray[4] = new Product("Dell XPS 13", "05.11.2023",
                "Dell", "USA", 11999, false);

        for (Product p : productsArray) {
            p.displayInfo();
        }
    }
}
