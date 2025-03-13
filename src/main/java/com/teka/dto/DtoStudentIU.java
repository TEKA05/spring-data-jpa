package com.teka.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU
{

    @NotEmpty(message = "FirstName alanı boş bırakılamaz!")
    @Min(value = 3 ,message = "first name min 3 karakter olmalıdır")
    @Max(value = 10, message = "first name max 10 karakter olmalıdır")
    private String first_name;

  //  @Size(min = 3, max = 30)
    private String  last_name;

    private Date birth_of_date;

 //   @Email(message = "Email formatında bir adres giriniz!")
    private String email;

 //   @Size(min = 11 , max =11, message = "T.C. numarası 11 haneli olmalıdır")
  //  @NotEmpty(message = "T.C. numarası boş geçilemez")
    private String tckn;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }
}
