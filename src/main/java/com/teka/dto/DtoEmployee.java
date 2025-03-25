package com.teka.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee
{
    private Long id;

    private String name;

    private DtoDepartment department;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DtoDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DtoDepartment department) {
        this.department = department;
    }
}
