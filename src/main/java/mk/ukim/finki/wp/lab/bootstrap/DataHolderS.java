package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolderS {

    public static List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init(){
        students.add(new Student("MakroS", "12345", "Marko", "S."));
        students.add(new Student("DarkoT", "12345", "Darko", "T."));
        students.add(new Student("IvanM", "12345", "Ivan", "M."));
        students.add(new Student("AndrejV", "12345", "Andrej", "V."));
        students.add(new Student("MartinG", "12345", "Martin", "G."));
    }
}
