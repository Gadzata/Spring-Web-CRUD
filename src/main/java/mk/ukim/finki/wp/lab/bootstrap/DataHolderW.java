package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolderW {

    public static List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
/*        List<Student> listStudents = DataHolderS.students;
        List<Teacher> listTeachers = DataHolderT.teachers;
        courses.add(new Course("Veb programiranje", "Web Spring",null ,new ArrayList<>(listStudents.subList(1,2)), listTeachers.get(0)));
        courses.add(new Course("Operativni Sistemi", "OS Windows",null ,new ArrayList<>(listStudents.subList(3,4)),listTeachers.get(1)));
        courses.add(new Course("Napredno Programiranje", "Java", null ,new ArrayList<>(listStudents.subList(0,2)),listTeachers.get(2)));
        courses.add(new Course("Mrezi", "Networks", null ,new ArrayList<>(listStudents.subList(2,4)), listTeachers.get(3)));
        courses.add(new Course("Verojatnost i Statistika", "Verojatnosti", null ,new ArrayList<>(listStudents.subList(0,4)),listTeachers.get(4)));*/
    }
}
