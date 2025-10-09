package com.grid.RestTemplateOps.service;

import com.grid.RestTemplateOps.entity.NameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CrudOpsService {

    @Autowired
    private  RestTemplate restTemplate;

    public static final String UrlToCrudService = "http://localhost:8080/api/crudops";

    public ResponseEntity<List<NameEntity>> getAllNames() {
        ResponseEntity<NameEntity[]> response = restTemplate.getForEntity(UrlToCrudService, NameEntity[].class);
        List<NameEntity> names = Arrays.asList(response.getBody());
        return new ResponseEntity<>(names, response.getStatusCode());
    }

    public ResponseEntity<NameEntity> createNmae(NameEntity name)
    {
        return restTemplate.postForEntity(UrlToCrudService + "/addStrign" , name, NameEntity.class);
    }

    public void deleteName(Long id)
    {
        restTemplate.delete(UrlToCrudService + "/2");
    }

}
