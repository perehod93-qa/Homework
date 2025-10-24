package lesson_4.shapes;

public abstract class GeometricFigure implements Measurable {
    protected String fillColor;
    protected String borderColor;

    public GeometricFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void printFullInfo() {
        printInfo();
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
        System.out.println("---------------------------");
    }
}