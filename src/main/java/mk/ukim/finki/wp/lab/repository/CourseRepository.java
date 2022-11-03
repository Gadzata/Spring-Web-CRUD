package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolderS;
import mk.ukim.finki.wp.lab.bootstrap.DataHolderT;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    public List<Course> findAllCourses() {
        return DataHolderT.courses;
    }

    public Course findById(Long courseId) {

        return DataHolderT.courses.stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    public List<Student> findAllStudentsByCourse(Long courseId){
        return DataHolderT.courses.stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().get().getStudents();
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


}
