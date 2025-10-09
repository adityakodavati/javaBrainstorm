package com.grid.CrudOperation.controller;


import com.grid.CrudOperation.entity.NameEntity;
import com.grid.CrudOperation.repository.CRUDRepsository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crudops")
public class SampleCRUDController {


    @Autowired
    CRUDRepsository repsository;

    @PostMapping("/addStrign")
    public ResponseEntity<NameEntity>addToDB(@RequestBody NameEntity data)
    {
     NameEntity savedValue =  repsository.save(data);

     return ResponseEntity.ok(savedValue);
    }

    @GetMapping("/getName/{name}")
    public ResponseEntity<NameEntity> getNameById(@PathVariable String name)
    {
      NameEntity nameEntity =  repsository.findByName(name);

      return new ResponseEntity<>(nameEntity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<NameEntity>> getAllNames() throws NullPointerException
    {
        List<NameEntity> namesList = repsository.findAll();
       String aditya = null;
        System.out.println(aditya.length());
        return new ResponseEntity<>(namesList, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        repsository.deleteById(id);
    }

}
