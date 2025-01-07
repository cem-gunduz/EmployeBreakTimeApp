package com.example.breaktime.business.abstracts;

import java.util.List;

import com.example.breaktime.entities.BreakLog;

public interface BreakLogService {

	BreakLog saveOneBreakLog(BreakLog newBreakLog);
	List<BreakLog> getBreakLogsByEmployeId(Long employeId);
	long calculateTotalTimeOutside(Long employeId);
}