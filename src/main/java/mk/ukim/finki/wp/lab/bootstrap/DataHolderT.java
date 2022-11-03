package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolderT {

    public static List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
        List<Student> listStudents = DataHolderS.students;
        courses.add(new Course((long)1, "Veb programiranje", "Web Spring", new ArrayList<>(listStudents.subList(1,2))));
        courses.add(new Course((long)2, "Operativni Sistemi", "OS Windows", new ArrayList<>(listStudents.subList(3,4))));
        courses.add(new Course((long)3, "Napredno Programiranje", "Java", new ArrayList<>(listStudents.subList(0,2))));
        courses.add(new Course((long)4, "Mrezi", "Networks", new ArrayList<>(listStudents.subList(2,4))));
        courses.add(new Course((long)5, "Verojatnost i Statistika", "Verojatnosti", new ArrayList<>(listStudents.subList(0,4))));
    }
}
