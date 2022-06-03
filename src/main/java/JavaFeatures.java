import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.*;

public class JavaFeatures {

    /**-----------------Main----------------------*/
    public static void main(String[] args) {

        //Create student based on birthdate
        studentList.add(new Student("Radu", LocalDate.of(1996, 8, 25), 10));
        studentList.add(new Student("Vlad", LocalDate.of(1993, 1, 15), 7));
        studentList.add(new Student("Ionut", LocalDate.of(1992, 4, 22), 8));

        //Create student based on age
        studentList.add(new Student("Stefan", 35, 6));
        studentList.add(new Student("Vali", 45, 4));
        studentList.add(new Student("Teo", 55, 5));

        //Create courses
        courseList.add(new Course("Math", 1));
        courseList.add(new Course("Science", 1));
        courseList.add(new Course("Geography", 2));
        courseList.add(new Course("Language", 2));

        //Display average grades
        displayAverageGrade();

        //Transform courses to json
        transformCoursesToJson();

        //Allocate courses to students
        allocateCoursesToStudents();

        //Allocate grades to students
        allocateGradesToStudents();
    }

    /**-----------------Lists----------------------*/
    public static List<Student> studentList = new ArrayList<>();
    public static List<Course> courseList = new ArrayList<>();
    public static List<String> courseListJson = new ArrayList<>();


    /**-----------------Methods----------------------*/

    private static void displayAverageGrade() {
        //Get all names
        String studentNames = studentList.stream()
                .map(Student::getName)
                .toString();

        //Get average grade
        double averageGrade = studentList.
                stream().
                mapToDouble(Student::getGrade).
                boxed().
                collect(teeing(
                        summingDouble(student -> student),
                        counting(),
                        (sum, count) -> sum / count));

        //Print message
        System.out.println(studentNames + "received an average grade of: " + averageGrade);
    }


    static private void allocateCoursesToStudents() {
        Random randomNr = new Random();

        for (Student student : studentList) {
            System.out.println(
                    //Get student names
                    student.getName() +
                            //Add needed String
                            " will participate to course: " +
                            //Get random course from course list in Json format
                            courseListJson.get
                                    (randomNr.nextInt
                                            (courseListJson.size() - 1)));
        }
    }

    static private void allocateGradesToStudents() {
        for (Student student : studentList) {
            System.out.println(Student.switchExpression(student));
        }
    }

    static private void transformCoursesToJson() {
        //Use method from Course class to transform to Json
        courseListJson = courseList.stream()
                .map(Course::toJson)
                .collect(toList());
    }
}