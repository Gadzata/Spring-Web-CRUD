package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolderW;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    public List<Course> findAllCourses() {
        return DataHolderW.courses;
    }

    public Course findById(Long courseId) {

        return DataHolderW.courses.stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    public List<Student> findAllStudentsByCourse(Long courseId){
        return DataHolderW.courses.stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().get().getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){
        if(course.getStudents().contains(student))
            return null;
        Course courseTemp = this.findById(course.getCourseId());
        if(courseTemp != null && student != null) {
            courseTemp.getStudents().add(student);
            return course;
        }
        return null;
    }

    public String saveCourse(String name, String description, Teacher teacher)
    {
        DataHolderW.courses.removeIf(i -> i.getName().equals(name));
        Course newCourse = new Course(name, description, null, new ArrayList<Student>(), teacher);
        DataHolderW.courses.add(newCourse);
        return name;
    }

    public Long deleteCourse(Long id)
    {
        DataHolderW.courses.removeIf(i -> i.getCourseId().equals(id));
        return id;
    }


}
