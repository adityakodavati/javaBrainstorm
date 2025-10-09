package com.grid.discovery_cllient_1.repository;

import com.grid.discovery_cllient_1.entity.NameEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDRepsository extends JpaRepository<NameEntity,Long> {

    public NameEntity findByName(String name);

}
