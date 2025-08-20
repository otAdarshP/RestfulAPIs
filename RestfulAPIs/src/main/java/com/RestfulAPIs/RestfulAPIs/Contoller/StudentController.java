package com.RestfulAPIs.RestfulAPIs.Contoller;

import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import com.RestfulAPIs.RestfulAPIs.Repository.StudentRepository;
import com.RestfulAPIs.RestfulAPIs.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    // constructor dependency injection using annotation


    @GetMapping("/students")
    private List getStudent(){
        return new StudentDTO(4L, "Adarsh", "adarsh@gmail.comv");
    }

    @GetMapping("/students/{id}")
    private StudentDTO getStudentId(@PathVariable){
        return new StudentDTO (3L, "Sanjay", "sanjay@gmail.com");
    }
}
