package com.teka.services.impl;

import com.teka.dto.DtoDepartment;
import com.teka.dto.DtoEmployee;
import com.teka.entites.Employee;
import com.teka.repository.EmployeeRepository;
import com.teka.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> findAllEmployees()
    {
        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
        List<Employee> employeeList= employeeRepository.findAll();
        if (employeeList != null && !employeeList.isEmpty())
        {
            for (Employee employee: employeeList)
            {
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(employee,dtoEmployee);

                dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),employee.getDepartment().getDepartmentName()));

                dtoEmployeeList.add(dtoEmployee);
            }
        }
        return dtoEmployeeList;
    }
}
