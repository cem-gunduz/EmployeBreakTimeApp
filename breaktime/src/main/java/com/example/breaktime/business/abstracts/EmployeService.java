package com.example.breaktime.business.abstracts;

import java.util.List;

import com.example.breaktime.entities.Employe;

public interface EmployeService {
	Employe saveOneEmploye(Employe newEmploye);
	Employe getEmployeById(Long employeId);
	List<Employe> getAllEmployes();
}
