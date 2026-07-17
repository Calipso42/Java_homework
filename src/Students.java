import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Student {
    public String name;
    public String group;
    public int course;
    public List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

public class Students {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Иван", "ИП-21", 2, List.of(4, 5, 3, 4)));
        studentList.add(new Student("Мария", "ЭК-11", 1, List.of(2, 3, 2, 2)));
        studentList.add(new Student("Олег", "ИП-21", 2, List.of(3, 3, 3, 4)));
        studentList.add(new Student("Анна", "ЮР-31", 3, List.of(5, 5, 5, 4)));

        System.out.println("Проверяем оценки и переводим курсы");
        removeBadStudents(studentList);
        promoteStudents(studentList);

        Set<Student> studentSet = new HashSet<>(studentList);

        System.out.println("\nСтуденты на 1 курсе");
        printStudents(studentSet, 1);

        System.out.println("\nСтуденты на 2 курсе");
        printStudents(studentSet, 2);

        System.out.println("\nСтуденты на 3 курсе");
        printStudents(studentSet, 3);

        System.out.println("\nСтуденты на 4 курсе");
        printStudents(studentSet, 4);
    }

    public static void removeBadStudents(List<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteStudents(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.course += 1;
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        int count = 0;
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("0");
        }
    }
}