package mk.ukim.finki.wp.lab.bootstrap;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolderT {

    public static List<Teacher> teachers  = new ArrayList<>();;

    @PostConstruct
    public void init()
    {
        teachers.add(new Teacher( (long)1, "Goran", "Velinov"));
        teachers.add(new Teacher( (long)2, "Sasho", "Gramatikov"));
        teachers.add(new Teacher( (long)3, "Dimitar", "Trajanov"));
        teachers.add(new Teacher( (long)4, "Kostadin", "Mishev"));
        teachers.add(new Teacher( (long)5, "Riste", "Stojanov"));
    }
}
