import School_Course.Course;
import School_Course.School;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolTest {
    private String validSchoolName = "Fontys UAS";
    private String inValidSchoolName = null;
    private LocalDate validOpeningDate = LocalDate.of(2019,10,9);
    private LocalDate inValidOpeningDate = null;
    private ArrayList<Course> courses = new ArrayList<Course>();

    @Test(expected = IllegalArgumentException.class)
    public void inValidSchoolNameShouldThrowsException(){
        School school = new School(inValidSchoolName, validOpeningDate,courses);
    }
    @Test
    public void validSchoolNameShouldNotThrowException(){
        School school = new School(validSchoolName, validOpeningDate,courses);
    }
    @Test (expected = IllegalArgumentException.class)
    public void inValidOpeningDateShouldThrowException(){
        School school = new School(validSchoolName, inValidOpeningDate,courses);
    }
    @Test (expected = IllegalArgumentException.class)
    public void inValidOpeningDateAndInvalidNameShouldThrowException(){
        School school = new School(inValidSchoolName, inValidOpeningDate,courses);
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
