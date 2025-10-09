package com.grid.CrudOperation.repository;

import com.grid.CrudOperation.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDRepsository extends JpaRepository<NameEntity,Long> {

    public NameEntity findByName(String name);

}
