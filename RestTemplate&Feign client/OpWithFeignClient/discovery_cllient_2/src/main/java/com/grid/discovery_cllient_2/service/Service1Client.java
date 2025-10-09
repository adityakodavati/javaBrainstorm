package com.grid.discovery_cllient_2.service;

import com.grid.discovery_cllient_2.entity.NameEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "discovery-cllient-1")
public interface Service1Client {

    @PostMapping("/api/crudops/addStrign")
    public ResponseEntity<NameEntity> addToDB(@RequestBody NameEntity data);

    @GetMapping("/api/crudops/getName/{name}")
    public ResponseEntity<NameEntity> getNameById(@PathVariable String name);

    @GetMapping("/api/crudops")
    public ResponseEntity<List<NameEntity>> getAllNames();


    @DeleteMapping("/api/crudops/{id}")
    public void deleteById(@PathVariable Long id);

}
