package com.RestfulAPIs.RestfulAPIs.Contoller;

import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import com.RestfulAPIs.RestfulAPIs.Service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final ModelMapper modelMapper;
    private final StudentService studentService;
    // constructor dependency injection using annotation


    @GetMapping("/students")
    private List<StudentDTO> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    private StudentDTO getStudentId(@PathVariable Long id){
        return studentService.getStudentsById(id);
    }
}
