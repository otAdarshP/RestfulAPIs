package com.RestfulAPIs.RestfulAPIs.Contoller;

import com.RestfulAPIs.RestfulAPIs.DTO.AddStudentDTO;
import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import com.RestfulAPIs.RestfulAPIs.Service.StudentService;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/students")
    private ResponseEntity<StudentDTO> createStudent (@RequestBody AddStudentDTO addStudentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentDTO));
    }
    @DeleteMapping("/students/{id}")
    private ResponseEntity<Void> deleteStudent (@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/students/{id}")
    private ResponseEntity<StudentDTO> updateStudent (@PathVariable Long id, @RequestBody AddStudentDTO addStudentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id, addStudentDTO));
    }
    @PatchMapping("/students/{id}")
    private ResponseEntity<StudentDTO> updatePatch (@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updatePatch(id, updates));
    }
}
