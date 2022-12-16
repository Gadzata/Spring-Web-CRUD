package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepositoryJpa;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepositoryJpa gradeRepository;

    public GradeServiceImpl(GradeRepositoryJpa gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Grade> findAll() {
        return this.gradeRepository.findAll();
    }

    @Override
    public Grade findGradeForStudent(String username) {
        return this.gradeRepository.getByStudentUsername(username);
    }

    @Override
    public Grade findGradeForStudent(Student student) {
        return this.gradeRepository.getByStudent(student);
    }

    @Override
    public Grade findGradeForCourse(Long courseId) {
        return this.gradeRepository.getByCourseCourseId(courseId);
    }

    @Override
    public Grade findGradeForCourse(Course course) {
        return this.gradeRepository.getByCourse(course);
    }

    @Override
    public List<Grade> findGradesForCourse(Long courseId) {
        return this.gradeRepository.getAllByCourseCourseId(courseId);
    }

    @Override
    public Grade getByStudentAndId(Student student, Long courseId) {
        return this.gradeRepository.getByStudentAndId(student, courseId);
    }
}
