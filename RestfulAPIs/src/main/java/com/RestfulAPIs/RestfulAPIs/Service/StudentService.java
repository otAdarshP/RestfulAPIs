package com.RestfulAPIs.RestfulAPIs.Service;
import java.util.List;
import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import com.RestfulAPIs.RestfulAPIs.Repository.StudentRepository;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentsById(Long id);


}

