package lesson_5;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Ошибка в ячейке [%d][%d]: значение \"%s\" не является числом", row, col, value));
    }
}