package lesson_4.shapes;

public class ShapesMain {
    public static void main(String[] args) {
        GeometricFigure[] figures = {
                new Circle(5, "Красный", "Чёрный"),
                new Rectangle(4, 6, "Синий", "Зелёный"),
                new Triangle(3, 4, 5, "Жёлтый", "Фиолетовый")
        };

        for (GeometricFigure figure : figures) {
            System.out.println(figure.getClass().getSimpleName() + ":");
            figure.printFullInfo();
        }
    }
}