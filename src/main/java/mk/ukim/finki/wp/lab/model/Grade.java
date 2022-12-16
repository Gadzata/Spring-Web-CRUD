package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private Character grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private LocalDateTime timestamp;
}