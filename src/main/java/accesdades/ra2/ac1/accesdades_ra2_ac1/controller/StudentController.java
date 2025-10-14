package accesdades.ra2.ac1.accesdades_ra2_ac1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/student")
    public String getStudent() {
        return "Endpoint get";
    }

    @PostMapping("/student/batch")
    public String addStudent() {
        return "Endpoint post";
    }
    
    

}
