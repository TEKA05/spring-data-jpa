package com.teka.services;

import com.teka.dto.DtoCustomer;

public interface ICustomerService
{
    public DtoCustomer findCustomerById(Long id);
}
