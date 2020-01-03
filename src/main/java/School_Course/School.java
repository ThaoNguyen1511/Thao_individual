package School_Course;

import School_Course.Course;

import java.time.LocalDate;
import java.util.ArrayList;

public class School {
    public School(String name, LocalDate openingDate, ArrayList<Course> courses) throws IllegalArgumentException {
         if(name == null || name =="")
             throw new IllegalArgumentException("Invalid School Name");
         if(openingDate == null)
             throw new IllegalArgumentException("Invalid Opening Date");
    }
}
