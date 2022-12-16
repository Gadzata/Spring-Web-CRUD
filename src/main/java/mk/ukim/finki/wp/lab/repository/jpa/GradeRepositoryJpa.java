package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepositoryJpa extends JpaRepository<Grade, Long> {
    Grade getByStudentUsername (String username);
    Grade getByStudent (Student student);
    Grade getByCourseCourseId (Long id);
    Grade getByCourse (Course course);
    List<Grade> getAllByCourseCourseId (Long id);
    Grade getByStudentAndId(Student student,Long courseId);
}
