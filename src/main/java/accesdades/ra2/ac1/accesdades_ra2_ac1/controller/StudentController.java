package accesdades.ra2.ac1.accesdades_ra2_ac1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accesdades.ra2.ac1.accesdades_ra2_ac1.model.Student;
import accesdades.ra2.ac1.accesdades_ra2_ac1.repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @PostMapping("/student/batch")
    public String addStudent() {
        int numReg = studentRepository.save();
        return String.format("Has afegit %d registre", numReg);
    }
    
    @PostMapping("/students/batch")
    public String add10Student() {
        int numReg = studentRepository.insert10Students();
        return String.format("Has afegit %d registres", numReg);
    }
    

}
