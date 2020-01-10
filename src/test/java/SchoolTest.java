import School_Course.Course;
import School_Course.School;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SchoolTest {
    private String validSchoolName = "Fontys UAS";
    private String inValidSchoolName = null;
    private LocalDate validOpeningDate = LocalDate.of(2019,10,9);
    private LocalDate inValidOpeningDate = null;

    private ArrayList<Course> courses = new ArrayList<Course>();

    public SchoolTest()  {
    }

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

    @Test(expected = IllegalArgumentException.class)
    public void addExistCourseToSchoolShouldThrowException()  {
        Course existCourse = new Course("TCI",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course = new Course("TCI",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course1 = new Course("EBUS",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course2 = new Course("T&H",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        courses.add(course);
        courses.add(course1);
        courses.add(course2);
        School school = new School(validSchoolName, validOpeningDate,courses);

        school.addCourseToSchool(existCourse);
    }
    @Test
    public void addUniqueCourseToSchoolShouldBeSuccess(){
        Course newCourse = new Course("TCI",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course1 = new Course("EBUS",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course2 = new Course("T&H",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        courses.add(course1);
        courses.add(course2);
        School school = new School(validSchoolName, validOpeningDate,courses);

        school.addCourseToSchool(newCourse);

        Assert.assertEquals("New course is not added!",3,courses.size());
    }
    @Test
    public void courseShouldBeGetByNameSuccessful(){
        String nameOfCourseToFind = "TCI";
        Course expectedResult = new Course("TCI",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course1 = new Course("EBUS",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        Course course2 = new Course("T&H",LocalDate.of(2019,8,9),LocalDate.of(2020,10,9));
        courses.add(course1);
        courses.add(course2);
        School school = new School(validSchoolName, validOpeningDate,courses);

        Course actualResult = school.getCourseByName(nameOfCourseToFind);

        Assert.assertEquals("Can not find Course by Name", expectedResult,actualResult);
    }
    @Test
    public void allCourseNameShouldBeGetSuccessful(){

    }
    @Test
    public void listCopiesOfCourseShouldBeGetSuccessful(){

    }

}
