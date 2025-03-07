package com.teka.controller.impl;

import com.teka.controller.IStudentController;
import com.teka.dto.DtoStudent;
import com.teka.dto.DtoStudentIU;
import com.teka.entites.Student;
import com.teka.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController
{
    @Autowired
    private IStudentService studentService;
    //DTO Kullanılır
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU)
     {

         return studentService.saveStudent(dtoStudentIU);
     }
     @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name ="id") Integer id)
    {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU)
    {
        return studentService.upDateStudent(id, dtoStudentIU);
    }


}
