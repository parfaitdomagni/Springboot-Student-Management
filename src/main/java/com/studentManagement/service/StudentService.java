package com.studentManagement.service;


import com.studentManagement.model.Students;

import java.util.List;

public interface StudentService {
     List<Students> getAllStudent();
     Students register(Students students);
     Students getStudentById(int student_id);

}
