package lesson_6.students;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentMain {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Иванов Иван", "A1", 1, List.of(4, 5, 5)));
        students.add(new Student("Петров Петр", "A1", 1, List.of(2, 3, 2)));
        students.add(new Student("Сидорова Анна", "B1", 2, List.of(3, 3, 4)));
        students.add(new Student("Кузнецов Олег", "C1", 3, List.of(5, 5, 5)));

        System.out.println("=== Исходный список студентов ===");
        students.forEach(System.out::println);

        StudentService studentService = new StudentService();

        studentService.removeLowPerformingStudents(students);
        studentService.promoteStudents(students);

        System.out.println("\n=== После удаления и перевода ===");
        students.forEach(System.out::println);

        System.out.println();
        studentService.printStudents(students, 2);
        studentService.printStudents(students, 4);
    }
}