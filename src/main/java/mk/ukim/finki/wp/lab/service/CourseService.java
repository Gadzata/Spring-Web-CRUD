package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;

import java.util.List;

public interface CourseService {

    public List<Student> listStudentsByCourse(Long courseId);
    public Course addStudentInCourse(String username, Long courseId);
    public List<Course> listAll();
    public String saveCourse(String name, String description, Teacher teacher);
    public Long deleteCourse(Long id);
    public String editCourse( String name, String description, Long id, Teacher teacher);
}
