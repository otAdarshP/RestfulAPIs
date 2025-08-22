package com.RestfulAPIs.RestfulAPIs.Service;
import java.util.List;
import java.util.Map;

import com.RestfulAPIs.RestfulAPIs.DTO.AddStudentDTO;
import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentsById(Long id);

    StudentDTO createStudent (AddStudentDTO addStudentDTO);

    void deleteStudent (Long id);

    StudentDTO updateStudent (long id, AddStudentDTO addStudentDTO);

    StudentDTO updatePatch (Long id, Map<String, Object> updates);

}

