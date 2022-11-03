package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolderS;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    public List<Student> findAllStudents(){
        return DataHolderS.students;
    }

    public List<Student> findAllByNameOrSurname(String text){
        return DataHolderS.students.stream().filter(r -> (r.getName().equals(text) || r.getSurname().equals(text))).collect(Collectors.toList());
    }

    public Student save(String username, String password, String name, String surname)
    {
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty())
        {
          return null;
        }
        if(username == null || password == null || name == null || surname == null)
        {
            return null;
        }
        Student studentTemp = new Student(username, password, name, surname);

        if(DataHolderS.students.stream().filter(s -> (Objects.equals(s,studentTemp) & s.getUsername().equals(studentTemp.getUsername()))).count() > 0) {
            return null;
        }
        DataHolderS.students.add(studentTemp);
        return studentTemp;
    }
}
