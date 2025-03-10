package com.teka.services.impl;

import com.teka.dto.DtoStudent;
import com.teka.dto.DtoStudentIU;
import com.teka.entites.Student;
import com.teka.repository.StudentRepository;
import com.teka.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<DtoStudent> getAllStudents()
    {
        List<DtoStudent> dtoList =new ArrayList<>();
        List<Student> studentList= studentRepository.findAllStudents();
        for (Student student: studentList)
        {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Integer id)
    {
        DtoStudent dto  = new DtoStudent();
        Optional <Student> optional =studentRepository.findStudentById(id);
        //ispresenet aslında değer varsa demek , veriyi bulduysan
        if (optional.isPresent())
        {
           Student dbStudent = optional.get();

           BeanUtils.copyProperties(dbStudent,dto);
        }
        return dto;
    }

    @Override
    public void deleteStudent(Integer id)
    {
     Optional <Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());

        }
     }

    @Override
    public DtoStudent upDateStudent(Integer id , DtoStudentIU dtoStudentIU)
    {

        DtoStudent dto = new DtoStudent();
       Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent())
        {
            Student dbStudent =optional.get();

            dbStudent.setFirst_name(dtoStudentIU.getFirst_name());
            dbStudent.setLast_name(dtoStudentIU.getLast_name());
            dbStudent.setBirth_of_date(dtoStudentIU.getBirth_of_date());

            Student updatedStudent =studentRepository.save(dbStudent);

            BeanUtils.copyProperties(updatedStudent,dto);
            return  dto;

        }
        return null;
    }


}
