package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJpa;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepositoryJpa courseRepository;
    private final StudentService studentService;

    public CourseServiceImpl(CourseRepositoryJpa courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    @Transactional
    public List<Student> listStudentsByCourse(Long courseId)
    {
        return courseRepository.findById(courseId).orElse(null).getStudents();
    }

    @Override
    @Transactional
    public Course addStudentInCourse(String username, Long courseId)
    {
        Student studentTemp = studentService.listAll().stream().filter(r -> r.getUsername().equals(username)).findFirst().orElse(null);
        if(studentTemp != null)
        {
            Course courseTemp = this.listAll().stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().orElse(null);
            assert courseTemp != null;
            courseTemp.getStudents().add(studentTemp);
            return courseRepository.save(courseTemp);
        }
        return null;
    }

    @Override
    public List<Course> listAll() {

        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public String saveCourse(String name, String description, Teacher teacher) {
        Course courseTemp = new Course(name, description,new ArrayList<>(), teacher);
        courseRepository.save(courseTemp);
        return "save";
    }
    public Long deleteCourse(Long id)
    {
        courseRepository.delete(courseRepository.getReferenceById(id));
        return id;
    }

    @Override
    @Transactional
    public String editCourse(String name, String description, Long id, Teacher teacher) {
        Course courseTemp = courseRepository.getReferenceById(id);
        if(courseTemp != null)
        {
            courseTemp.setName(name);
            courseTemp.setDescription(description);
            courseTemp.setTeacher(teacher);
        }
        return name;
    }
}
