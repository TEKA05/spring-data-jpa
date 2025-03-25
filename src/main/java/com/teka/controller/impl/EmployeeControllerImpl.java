package com.teka.controller.impl;


import com.teka.controller.IEmployeeController;
import com.teka.dto.DtoEmployee;
import com.teka.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController
{
    @Autowired
    private IEmployeeService employeeService;


    @GetMapping(path = "/list")
    @Override
    public List<DtoEmployee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }
}
