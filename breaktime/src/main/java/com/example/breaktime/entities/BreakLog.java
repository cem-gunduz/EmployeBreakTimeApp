package com.example.breaktime.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class BreakLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "break_log_id")
	private long breakLogId;
		
	@ManyToOne
	@JoinColumn(name = "employe_id", nullable = false)
	private Employe employe;
	
	@Column(name = "break_entry_time")
	private LocalDateTime entryTime;
	
	@Column(name = "break_exit_id")
	private LocalDateTime exitTime;
}
