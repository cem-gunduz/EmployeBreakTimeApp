package com.example.breaktime.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.breaktime.business.abstracts.EmployeService;
import com.example.breaktime.dataAccess.EmployeDao;
import com.example.breaktime.entities.Employe;

@Service
public class EmployeManager implements EmployeService{

	private EmployeDao employeDao;
	
	public EmployeManager(EmployeDao employeDao) {
		this.employeDao = employeDao;
		
	}
	
	@Override
	public Employe saveOneEmploye(Employe newEmploye) {
		return employeDao.save(newEmploye);
	}
	
	@Override
	public Employe getEmployeById(Long employeId) {
		return employeDao.findById(employeId).orElse(null);
		
	}

	@Override
	public List<Employe> getAllEmployes() {
		return employeDao.findAll();
	}

}

