package School_Course;

import java.time.LocalDate;

public class Course {
    public String courseName;
    public LocalDate startDate;
    public LocalDate endDate;
    public Course(String name, LocalDate startDate, LocalDate endDate) throws CourseDateException{
        this.courseName = name;
        if(startDate.compareTo(endDate)>0){
            throw new CourseDateException();
        }
        else{
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    private class CourseDateException extends Exception {

    }
}
