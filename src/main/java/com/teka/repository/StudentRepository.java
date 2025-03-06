package com.teka.repository;

import com.teka.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Jpa içerisindeki metodları kullanmak için  ana clasımız studentin içerisinde id nın tanımlı olduğu tip integer olduğu için parametre Integer dönderdik.
@Repository
public interface StudentRepository extends JpaRepository <Student,Integer>{
}
