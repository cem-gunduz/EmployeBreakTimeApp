package com.example.breaktime.dataAccess;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.breaktime.entities.BreakLog;

public interface BreakLogDao extends JpaRepository<BreakLog,Long>{

	List<BreakLog> findByEmployeId(Long employeId);
}
