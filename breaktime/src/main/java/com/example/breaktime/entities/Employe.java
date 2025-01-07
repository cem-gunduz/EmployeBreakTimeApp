package com.example.breaktime.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employe_id")
	private long id;
		
	@Column(name = "employe_name")
	private String name;
	
	@Column(name = "employe_surname")
	private String surname;
	
	@Column(name = "employe_department")
	private String department;
	
	@OneToMany(mappedBy = "employe",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BreakLog> breakLogs;
}
