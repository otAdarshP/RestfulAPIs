package com.RestfulAPIs.RestfulAPIs.Service.Impl;
import java.util.List;
import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import com.RestfulAPIs.RestfulAPIs.Entity.Student;
import com.RestfulAPIs.RestfulAPIs.Repository.StudentRepository;
import com.RestfulAPIs.RestfulAPIs.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOList = students.stream().map(student -> new StudentDTO (student.getId(), student.getName(), student.getEmail())).toList();
        return studentDTOList;
    }
}
