package lesson_4.shapes;

public interface Measurable {
    double getPerimeter();
    double getArea();

    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
    }
}