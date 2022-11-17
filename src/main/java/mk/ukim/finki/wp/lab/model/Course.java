package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private Long courseId;
    private String name;
    private String description;
    private List<Student> students;
    private Teacher teacher;

    public Course(String name, String description, Long id, List<Student> students, Teacher teacher) {
        if(id == null)
            this.courseId = (long) (Math.random() * 1000);
        else
            this.courseId = id;
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }
}
