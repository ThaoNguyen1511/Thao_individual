package School_Course;

import School_Course.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class School {
    public School(String name, LocalDate openingDate, ArrayList<Course> courses) throws IllegalArgumentException {
         if(name == null || name =="")
             throw new IllegalArgumentException("Invalid School Name");
         if(openingDate == null)
             throw new IllegalArgumentException("Invalid Opening Date");
    }

    public Course getCourseByName(String name){
        return null;
    }
    public Set<String> getListOfCourseName(){
        return null;
    }
    public Set<Course> getListCopiesOfAllCourse(){
        return null;
    }

    public void addCourseToSchool(){

    }
}
