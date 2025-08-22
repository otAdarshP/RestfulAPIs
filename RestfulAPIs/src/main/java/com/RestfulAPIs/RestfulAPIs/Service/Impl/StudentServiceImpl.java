package com.RestfulAPIs.RestfulAPIs.Service.Impl;
import java.util.List;
import java.util.Map;

import com.RestfulAPIs.RestfulAPIs.DTO.AddStudentDTO;
import com.RestfulAPIs.RestfulAPIs.DTO.StudentDTO;
import com.RestfulAPIs.RestfulAPIs.Entity.Student;
import com.RestfulAPIs.RestfulAPIs.Repository.StudentRepository;
import com.RestfulAPIs.RestfulAPIs.Service.StudentService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO getStudentsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createStudent (AddStudentDTO addStudentDTO){
        Student newStudent = modelMapper.map(addStudentDTO, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudent (Long id){
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Id does not exist.");
        }
        else{
            studentRepository.deleteById(id);
        }
    }

    @Override
    public StudentDTO updateStudent (long id, AddStudentDTO addStudentDTO){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Does not exist"));
        modelMapper.map (addStudentDTO, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updatePatch (Long id, Map<String, Object> updates){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Does not exist."));

        updates.forEach((key, value) -> {
            switch(key) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default: throw new IllegalArgumentException("the data doesnot exist.");
            }
        });
        Student patchedStudent = studentRepository.save(student);
        return modelMapper.map(patchedStudent, StudentDTO.class);
    }
}
