package com.teka.services.impl;

import com.teka.dto.DtoStudent;
import com.teka.dto.DtoStudentIU;
import com.teka.entites.Student;
import com.teka.repository.StudentRepository;
import com.teka.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU)
    {
        DtoStudent responce = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU,student);

        Student dbStudent= studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent , responce);
        return  responce;

    }



    @Override
    public List<Student> getAllStudents()
    {
        List<Student> studentList= studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(Integer id)
    {
        Optional <Student> optional =studentRepository.findById(id);
        //ispresenet aslında değer varsa demek , veriyi bulduysan
        if (optional.isPresent())
        {
           return optional.get();
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id)
    {
     Student dbStudent = getStudentById(id);
     if(dbStudent!=null) {
         studentRepository.delete(dbStudent);
     }
     }

    @Override
    public Student upDateStudent(Integer id, Student updateStudent)
    {
        Student dbStudent = getStudentById(id);
        if (dbStudent!=null)
        {
            dbStudent.setFirst_name(updateStudent.getFirst_name());
            dbStudent.setLast_name(updateStudent.getLast_name());
            dbStudent.setBirth_of_date(updateStudent.getBirth_of_date());

            studentRepository.save(dbStudent);

        }
        return null;
    }


}
