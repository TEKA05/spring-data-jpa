package com.teka.services;


import com.teka.dto.DtoStudent;
import com.teka.dto.DtoStudentIU;
import com.teka.entites.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public  DtoStudent getStudentById(Integer id);

    public void deleteStudent (Integer id);

    public DtoStudent upDateStudent (Integer id , DtoStudentIU dtoStudentIU);


}
