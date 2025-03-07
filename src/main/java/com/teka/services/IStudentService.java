package com.teka.services;


import com.teka.dto.DtoStudent;
import com.teka.dto.DtoStudentIU;
import com.teka.entites.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<Student> getAllStudents();

    public  Student getStudentById(Integer id);

    public void deleteStudent (Integer id);

    public Student upDateStudent (Integer id , Student updateStudent);


}
