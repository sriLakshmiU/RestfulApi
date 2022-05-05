package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter long id;
	@Column(name = "First_Name")
	@Getter @Setter String firstName;
	@Column(name = "Last_Name")
	@Getter @Setter String lastName;
	@Column(name = "email")
	@Getter @Setter String email;

	
	@Override public String toString() { return "Employee [id=" + id +
			  ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +
			 "]"; }
}
