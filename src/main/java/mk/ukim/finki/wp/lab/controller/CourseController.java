package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.bootstrap.DataHolderT;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("listCourses", courseService.listAll());
        return "listCourses";
    }

    @PostMapping
    public String courses(@RequestParam String courseId, HttpServletRequest req){
        req.getSession().setAttribute("courseId",courseId);
        return "redirect:/AddStudent";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.courseService.deleteCourse(id);

        return "redirect:/courses";
    }


    @GetMapping("/add")
    public String addProductPage(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "addCourse";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long IdCourse,
            @RequestParam String nameCourse,
            @RequestParam String desccription,
            @RequestParam Long teacherId) {

        if (IdCourse == null)
        {
            Teacher teacherTemp = teacherService.findAll().stream().filter(i -> i.getId().equals(teacherId)).findFirst().get();
            courseService.saveCourse(nameCourse, desccription, teacherTemp);
        }
        else
        {
            Teacher teacherTemp = teacherService.findAll().stream().filter(i -> i.getId().equals(teacherId)).findFirst().get();
            courseService.editCourse(nameCourse, desccription, IdCourse, teacherTemp);
        }
        return "redirect:/courses";
    }


    @GetMapping("/edit-form/{id}")
    public String editCoursePage(@PathVariable Long id, Model model) {
        if (this.courseService.listAll().stream().anyMatch(i -> i.getCourseId().equals(id))) {
            Course courseTemp = courseService.listAll().stream().filter(i -> i.getCourseId().equals(id)).findFirst().get();
            model.addAttribute("teachers", teacherService.findAll());
            model.addAttribute("teacherSelect", courseTemp.getTeacher());
            model.addAttribute("courseName", courseTemp.getName());
            model.addAttribute("courseID", courseTemp.getCourseId());
            model.addAttribute("students", courseTemp.getStudents());
            model.addAttribute("description", courseTemp.getDescription());
            return "addCourse";
        }
        return "redirect:/products?error=ProductNotFound";
        //saat i 3 minuta za implementacija
    }

    }
