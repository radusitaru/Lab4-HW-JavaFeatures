import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public record Student(String name, LocalDate birthDate, int grade) {

    /**
     * -----------------Variables----------------------
     */

    static Random x = new Random();

    /**
     * -----------------Constructor----------------------
     */

    public Student(String name, int age, int grade) {
        this(name, LocalDate.of(LocalDate.now().getYear() - age, x.nextInt(1, 12), x.nextInt(1, 28)), grade);
    }

    /**
     * -----------------Methods----------------------
     */

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    static String switchExpression(Student student) {
        int positionInList = JavaFeatures.studentList.indexOf(student);

        String result = switch (positionInList) {
            case 0, 1, 2 -> student.getName() + " received 1st grade.";
            case 3 -> student.getName() + " received 5th grade.";
            default -> student.getName() + " received 7th grade.";
        };
        return result;
    }
}
