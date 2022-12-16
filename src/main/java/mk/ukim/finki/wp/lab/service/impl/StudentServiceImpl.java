package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryJpa studentRepository;

    public StudentServiceImpl(StudentRepositoryJpa studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    @Transactional
    public List<Student> listAll() {

        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {

        return studentRepository.findStudentsByNameOrSurname(text, text);
    }

    @Override
    @Transactional
    public Student save(String username, String password, String name, String surname)
    {
        Student studentTemp = new Student(username, password, name, surname);
        return studentRepository.save(studentTemp);
    }
}
