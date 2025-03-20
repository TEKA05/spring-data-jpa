package com.teka.controller;

import com.teka.dto.DtoCustomer;

public interface ICustomerController
{
    public DtoCustomer findCustomerById(Long id);

}
