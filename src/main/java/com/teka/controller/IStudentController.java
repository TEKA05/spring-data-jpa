package com.teka.controller;


import com.teka.dto.DtoStudent;
import com.teka.dto.DtoStudentIU;


import java.util.List;

public interface IStudentController
{

   public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

   public List<DtoStudent> getAllStudents();

   public DtoStudent getStudentById(Integer id);

   public void deleteStudent(Integer id);

   public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
