package com.teka.controller;

import com.teka.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController
{
    public List<DtoEmployee> findAllEmployees();
}
