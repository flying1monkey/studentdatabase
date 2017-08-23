package edu.berliner.studentdatabase.controllers;

import edu.berliner.studentdatabase.models.Student;
import edu.berliner.studentdatabase.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController
{
    @Autowired
    StudentRepository studentRepo;


    @GetMapping("/")
    public String home()
    {
        return "index";
    }

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/addstudent")
    public String addStudent(Model model)
    {
        model.addAttribute("newstudent", new Student());
        return "addstudent";
    }

    @PostMapping("/addstudent")
    public String submitStudent(@Valid @ModelAttribute("newstudent") Student student, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addstudent";
        }
        studentRepo.save(student);
        return "redirect:/addstudent";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/showstudents")
    public String showstudents(Model model)
    {
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "showstudents";
    }
}
