import com.google.gson.Gson;

public record Course(String courseName, int courseSemester) {

    /**-----------------Methods----------------------*/

    public String toJson() {
        return new Gson().toJson(new Course(this.courseName,this.courseSemester));
    }
}
