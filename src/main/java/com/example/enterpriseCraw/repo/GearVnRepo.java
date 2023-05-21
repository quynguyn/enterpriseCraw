package com.example.enterpriseCraw.repo;

import com.example.enterpriseCraw.model.GearVn;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GearVnRepo extends JpaRepository<GearVn,String> {

    List<GearVn> findByComponent(String component);
    List<GearVn> findByComponentOrderByPriceAsc(String component);
}
