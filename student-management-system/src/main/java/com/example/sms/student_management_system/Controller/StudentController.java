package com.example.sms.student_management_system.Controller;

import com.example.sms.student_management_system.Entity.Student;
import com.example.sms.student_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Handler method to handle list of students
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    @GetMapping("/students/new")
    public  String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";


    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
    	model.addAttribute("student", studentService.getStudentById(id));
    	
    	
    	
		return "edit_student";
    	
    	
    }
    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student , Model model) {
    	
    	//get student from database by id
    	Student existingStudent = studentService.getStudentById(id);
    	existingStudent.setId(id);
    	existingStudent.setName(student.getName());
    	existingStudent.setAge(student.getAge());

    	existingStudent.setEmail(student.getEmail());
    	// save updated student object
    	studentService.updateStudent(existingStudent);
    	return "redirect:/students";
    	
    	
    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
    	studentService.deleteStudentById(id);
    	return "redirect:/students";
    	
    	
    }
}
