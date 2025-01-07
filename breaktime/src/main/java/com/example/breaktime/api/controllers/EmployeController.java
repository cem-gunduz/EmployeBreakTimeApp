package com.example.breaktime.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.breaktime.business.abstracts.EmployeService;
import com.example.breaktime.entities.Employe;

@RestController
@RequestMapping("/employes")
public class EmployeController {

	private EmployeService employeService;
	
	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	@PostMapping
	public Employe saveOneEmploye(@RequestBody Employe newEmploye) {
		return employeService.saveOneEmploye(newEmploye);
	}
	
	@GetMapping("/getall")
	public List<Employe>getAllEmployes(){
		return employeService.getAllEmployes();
	}
	
	@GetMapping("/{employeId}")
	public Employe getEmployeById(@PathVariable Long employeId) {
		return employeService.getEmployeById(employeId);
	}
}

