package School_Course;

import java.time.LocalDate;

public class Course {
    public String courseName;
    public LocalDate startDate;
    public LocalDate endDate;
    public Course(String name, LocalDate startDate, LocalDate endDate) {
        this.courseName = name;
        if(startDate.compareTo(endDate)>0){
            throw new CourseDateException("StartDate should be earlier than EndDate!!!");
        }
        else{
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    public class CourseDateException extends RuntimeException{
        public CourseDateException(String error){
            super(error);
        }
    }
}
