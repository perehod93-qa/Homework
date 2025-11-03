package lesson_6.students;

import java.util.Iterator;
import java.util.Set;

public class StudentService {

    public void removeLowPerformingStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        students.stream()
                .filter(s -> s.getCourse() == course)
                .forEach(s -> System.out.println(" - " + s.getName()));
    }
}