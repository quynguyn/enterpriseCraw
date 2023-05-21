package com.example.enterpriseCraw.repo;

import com.example.enterpriseCraw.model.GearVn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearVnRepo extends JpaRepository<GearVn,String> {

}
