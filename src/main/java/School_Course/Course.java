package School_Course;

import java.time.LocalDate;

public class Course implements Comparable<Course> {
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

    @Override
    public int compareTo(Course course) {
       // return this.number.compareTo(chapter.number);
    return 0;
    }
    public boolean equals(Object o){
        Course c = (Course)o;
        return (this.courseName.equals(c.courseName )&& this.startDate.equals(c.startDate)&& this.endDate.equals(c.endDate));
    }

    public class CourseDateException extends RuntimeException{
        public CourseDateException(String error){
            super(error);
        }
    }
}
