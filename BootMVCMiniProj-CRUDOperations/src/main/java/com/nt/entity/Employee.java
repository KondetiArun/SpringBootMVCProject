package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="emp")
public class Employee 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "EMP_ID_SEQ",initialValue = 1500,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length=30)
	@NonNull
	private String ename;
	
	@Column(length=30)
	@NonNull
	private String job;
	
	@NonNull
	private Double sal;

}
