package com.teka.services;

import com.teka.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService
{

    public List<DtoEmployee> findAllEmployees();
}
