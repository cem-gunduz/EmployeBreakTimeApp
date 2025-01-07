package com.example.breaktime.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.breaktime.business.abstracts.BreakLogService;
import com.example.breaktime.entities.BreakLog;

@RestController
@RequestMapping("/breaklogs")
public class BreakLogController {

	private BreakLogService breakLogService;
	
	public BreakLogController(BreakLogService breakLogService) {
		this.breakLogService=breakLogService;		
	}

	@PostMapping
	public BreakLog saveOneBreakLog(@RequestBody BreakLog newBreakLog) {
		return breakLogService.saveOneBreakLog(newBreakLog);
	}
	
	@GetMapping("/{employeId}")
	public List<BreakLog> getBreakLogsByEmployeId(@PathVariable Long employeId){
		return breakLogService.getBreakLogsByEmployeId(employeId);
	}
	
	@GetMapping("/totaltime/{employeId}")
    public ResponseEntity<String> getTotalTimeOutside(@PathVariable Long employeId) {
        long totalMinutes = breakLogService.calculateTotalTimeOutside(employeId);
        long hours = totalMinutes / 60;
        long minutes = totalMinutes % 60;
        return ResponseEntity.ok("Total time outside: " + hours + " hours and " + minutes + " minutes.");
    }
}
