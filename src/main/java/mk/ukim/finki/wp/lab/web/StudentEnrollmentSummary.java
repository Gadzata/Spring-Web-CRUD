package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "student-enrolment", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;


    public StudentEnrollmentSummary(SpringTemplateEngine springTemplateEngine, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("courseID") == null)
        {
            resp.sendRedirect("/listCourses");
            return;
        }
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String studentUsername = (String) req.getSession().getAttribute("studentUsername");
        String id = (String) req.getSession().getAttribute("courseID");
        Long courseId = Long.parseLong(id);
        courseService.addStudentInCourse(studentUsername, Long.parseLong(id));
        Course courseTemp = this.courseService.listAll().stream().filter(r -> Objects.equals(r.getCourseId(), courseId)).findFirst().orElse(null);
        context.setVariable("course", courseTemp);
        this.springTemplateEngine.process("studentsInCourse.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
