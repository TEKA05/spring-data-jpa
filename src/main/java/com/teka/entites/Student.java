package com.teka.entites;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@Data // data aslında getter ve setterın birliştiri anositation
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// ID +1 ARTTIRIR , SEQUENCE BENZE,
    private Integer id;

    @Column(name = "first_name" ,nullable = false)
    private String first_name;

    @Column(name = "last_name",nullable = false)
    private String last_name;

    @JsonFormat(pattern = "yyyy-MM-dd")// date format annostation veya @DateTimeFormat annostationuda kullanılabilir.
    @Column(name = "birth_of_date",nullable = true)
    private Date birth_of_date;

    @ManyToMany
    @JoinTable(name ="student_course",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth_of_date() {
        return birth_of_date;
    }

    public void setBirth_of_date(Date birth_of_date) {
        this.birth_of_date = birth_of_date;
    }
}
