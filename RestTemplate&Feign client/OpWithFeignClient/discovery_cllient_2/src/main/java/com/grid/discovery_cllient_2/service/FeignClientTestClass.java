package com.grid.discovery_cllient_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignClientTestClass {

    @Autowired
    Service1Client service1Client;

    public void printAllNames()
    {
        System.out.println(service1Client.getAllNames());
    }

    public void deleteById(Long id)
    {
        service1Client.deleteById(id);
    }

}
