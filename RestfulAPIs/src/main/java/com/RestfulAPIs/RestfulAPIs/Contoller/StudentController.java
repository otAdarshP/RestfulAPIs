package com.RestfulAPIs.RestfulAPIs.Contoller;

import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    private StudentDTO getStudent(){
        return new StudentDTO(4L, "Adarsh", "adarsh@gmail.comv");
    }
}
