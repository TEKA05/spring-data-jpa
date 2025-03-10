package com.teka.repository;

import com.teka.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Jpa içerisindeki metodları kullanmak için  ana clasımız studentin içerisinde id nın tanımlı olduğu tip integer olduğu için parametre Integer dönderdik.
@Repository
public interface StudentRepository extends JpaRepository <Student,Integer>
{
    //HQL SORGUSU  value değeri içerisideki Student class ismi ile aynı olmadı , değişken isimleri kullanılarak sorgu yazılır , navtiveQuery false olur .
  //@Query(value = "from Student" , nativeQuery = false)
   // List<Student> findAllStudents();

    //SQL ise tablo ismi ve tablo içerisindeki kolon isimleri ile sorgu yazılır , navtiveQuery true olur
    @Query(value = "select * from student.student" , nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "from Student s where s.id= :studentId")
    Optional<Student> findStudentById(Integer studentId);
}
