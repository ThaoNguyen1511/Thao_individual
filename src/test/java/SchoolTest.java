import School_Course.Course;
import School_Course.School;
import org.junit.Test;

import java.util.ArrayList;

public class SchoolTest {
    private String validSchoolName = "Fontys UAS";
    private String inValidSchoolName = null;
    private String validOpeningDate = "10-09-2019";
    private String inValidOpeningDate = null;
    private ArrayList<Course> courses = new ArrayList<Course>();

    @Test(expected = IllegalArgumentException.class)
    public void inValidSchoolNameShouldThrowsException(){
        School school = new School(inValidSchoolName, validOpeningDate,courses);
    }
    @Test
    public void validSchoolNameShouldNotThrowException(){

    }
    @Test
    public void inValidOpeningDateShouldThrowException(){

    }
    @Test
    public void addExistCourseToSchoolShouldThrowException(){

    }
    @Test
    public void addUniqueCourseToSchoolShouldBeSuccess(){

    }
    @Test
    public void courseNameShouldBeGetByNameSuccessful(){

    }
    @Test
    public void allCourseNameShouldBeGetSuccessful(){

    }
    @Test
    public void listCopiesOfCourseShouldBeGetSuccessful(){

    }

}
