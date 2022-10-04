package com.studentManagement.service;

import com.studentManagement.exception.ResourceNotFoundException;
import com.studentManagement.model.Students;
import com.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudent() {

        return studentRepository.findAll();
    }

    @Override
    public Students register(Students students) {

       return  studentRepository.save(students);
    }

    @Override
    public Students getStudentById(int student_id) {
        Optional<Students> studentId = studentRepository.findById(student_id);
        if(studentId.isPresent()){
            return studentId.get();
        }else{
            throw new ResourceNotFoundException("Student", "Id", student_id);
        }

    }


    @Override
    public Students updateStudent(Students stud, int id) {
        Students existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("student", "id",id));
//       Optional<Students> existingStudent = studentRepository.findById(id);
//        if(existingStudent.isPresent()){
//            return existingStudent.get();
//        }else{
//            throw new ResourceNotFoundException("student", "id",id);
//        }

        existingStudent.setFrst_name(stud.getFrst_name());
        existingStudent.setLast_name(stud.getLast_name());
        existingStudent.setEmail(stud.getEmail());
        studentRepository.save(existingStudent);
        return existingStudent;

    }
}
