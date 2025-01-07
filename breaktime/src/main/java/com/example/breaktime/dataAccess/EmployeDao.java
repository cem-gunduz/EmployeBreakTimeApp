package com.example.breaktime.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.breaktime.entities.Employe;

public interface EmployeDao extends JpaRepository<Employe, Long>{

}
