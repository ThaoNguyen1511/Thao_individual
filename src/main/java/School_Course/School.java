package School_Course;

import School_Course.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class School {
    public String schoolName;
    public LocalDate openingDate;
    public ArrayList<Course> courses;
    public School(String name, LocalDate openingDate, ArrayList<Course> courses) throws IllegalArgumentException {
         if(name == null || name =="")
             throw new IllegalArgumentException("Invalid School Name");
         if(openingDate == null)
             throw new IllegalArgumentException("Invalid Opening Date");
         this.schoolName = name;
         this.openingDate = openingDate;
         this.courses = courses;
    }

    public Course getCourseByName(String name){
        return null;
    }
    public ArrayList<String> getListOfCourseName(){
        ArrayList<String> listOfCourseNames = new ArrayList<>();
        for(int i=0;i<courses.size();i++){
            listOfCourseNames.add(courses.get(i).courseName);
        }
        return listOfCourseNames;
    }
    public Set<Course> getListCopiesOfAllCourse(){
        return null;
    }

    public void addCourseToSchool(Course c)  {
        for(Course course : courses){
            if(c.equals(course)){
                throw new IllegalArgumentException ("Course already exists. Can not add!");
            }
        }
        courses.add(c);
    }
}
