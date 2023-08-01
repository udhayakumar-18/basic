package com.example.assi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.example.assi.model.Ass1;

public interface GetRepository extends JpaRepository<Ass1,Long> {
    
}
