package School_Course;

import java.time.LocalDate;

public class Course {
    private String courseName;
    private LocalDate startDate;
    private LocalDate endDate;
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
