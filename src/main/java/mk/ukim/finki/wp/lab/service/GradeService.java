package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;

public interface GradeService {


    public List<Grade> findAll();

    public Grade findGradeForStudent(String username);


    public Grade findGradeForStudent(Student student);


    public Grade findGradeForCourse(Long courseId);


    public Grade findGradeForCourse(Course course);


    public List<Grade> findGradesForCourse(Long courseId);


    public Grade getByStudentAndId(Student student, Long courseId);
}
