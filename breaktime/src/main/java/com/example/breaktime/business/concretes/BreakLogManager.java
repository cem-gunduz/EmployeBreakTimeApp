package com.example.breaktime.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import java.time.Duration;

import com.example.breaktime.business.abstracts.BreakLogService;
import com.example.breaktime.dataAccess.BreakLogDao;
import com.example.breaktime.entities.BreakLog;

@Service
public class BreakLogManager implements BreakLogService{

private BreakLogDao breakLogDao;
	
	public BreakLogManager(BreakLogDao breakLogDao) {
		this.breakLogDao = breakLogDao;
	}
	
	 public BreakLog saveOneBreakLog(BreakLog breakLog) {
	    return breakLogDao.save(breakLog);
	}
	
	 public List<BreakLog> getBreakLogsByEmployeId(Long employeId) {
	    return breakLogDao.findByEmployeId(employeId);
	}
		
	public long calculateTotalTimeOutside(Long employeId) {
	    List<BreakLog> logs = getBreakLogsByEmployeId(employeId);
	    
	    // Toplam süreyi dakikalar cinsinden hesaplayacağız.
	    long totalMinutes = logs.stream()
	        .filter(log -> log.getEntryTime() != null && log.getExitTime() != null)
	        .mapToLong(log -> Duration.between(log.getEntryTime(), log.getExitTime()).toMinutes())
	        .sum();
	    
	    return totalMinutes;
	}
	
}
