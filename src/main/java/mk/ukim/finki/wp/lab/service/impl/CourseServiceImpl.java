package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId)
    {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId)
    {
        Student studentTemp = studentService.listAll().stream().filter(r -> r.getUsername().equals(username)).findFirst().orElse(null);
        Course courseTemp = this.listAll().stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().orElse(null);
        return courseRepository.addStudentToCourse(studentTemp, courseTemp);
    }

    @Override
    public List<Course> listAll() {

        return courseRepository.findAllCourses();
    }

    @Override
    public String saveCourse(String name, String description, Teacher teacher) {
        return courseRepository.saveCourse(name,description, teacher);
    }
    public Long deleteCourse(Long id)
    {
        courseRepository.deleteCourse(id);
        return id;
    }

    @Override
    public String editCourse(String name, String description, Long id, Teacher teacher) {
        if(courseRepository.findById(id) != null)
        {
            courseRepository.findById(id).setName(name);
            courseRepository.findById(id).setDescription(description);
            courseRepository.findById(id).setTeacher(teacher);
        }
        return name;
    }
}
