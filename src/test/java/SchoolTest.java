import org.junit.Test;

public class SchoolTest {
    private String validSchoolName = "Fontys UAS";
    private String inValidSchoolName = "";
    @Test
    public void inValidSchoolNameShouldThrowsException(){
        School school = new School(inValidSchoolName);
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
