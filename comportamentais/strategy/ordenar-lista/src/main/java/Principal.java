import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;;

/**
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    private static final int TOTAL_STUDENTS = 1000;
    private final List<Student> students;
    public static final Comparator<Student> comparator = Comparator.comparing(Student::getName)
                                                                   .thenComparing(Student::getScore);

    public Principal(){
        students = StudentGenerator.generate(TOTAL_STUDENTS);
        students.sort(comparator);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        new Principal();
    }
}

