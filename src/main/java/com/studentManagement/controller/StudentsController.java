package com.studentManagement.controller;

import com.studentManagement.model.Students;
import com.studentManagement.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentsController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    public StudentsController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping("/getAllStudent")
    public  List<Students> getAll(){
        List<Students> studentsList = studentServiceImpl.getAllStudent();
        return studentsList;
    }
    @PostMapping("/registration")
    public ResponseEntity<Students> registerStudent(@RequestBody Students std){
        return new ResponseEntity<Students>(studentServiceImpl.register(std), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable("{id}") int std_id){
        return new ResponseEntity<Students>(studentServiceImpl.getStudentById(std_id), HttpStatus.OK    );
    }
    @PutMapping( "{id_id}")
    public ResponseEntity<Students> updateStudentInfo(@PathVariable("id_id") int id,
                                                      @RequestBody Students studentInfo){

        return new ResponseEntity<Students>(studentServiceImpl.updateStudent(studentInfo, id), HttpStatus.OK);
    }





}
