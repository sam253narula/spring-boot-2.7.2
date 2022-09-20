package com.example.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.exceptions.EmployeeAlreadyExistRuntimeException;
import com.example.repository.EMSRepository;

@RestController
@RequestMapping("ems")
public class EMSController {

	@Autowired
	EMSRepository emsRepository;

	@Autowired
	EntityManager entityManager;

	public EMSController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getEmplyeesWithThisName")
	public List<Employee> getEmplyeesWithThisName(String name) {
		TypedQuery<Employee> query = entityManager
				.createQuery("Select e from Employee e where e.name = '" + name + "'", Employee.class);
		return query.getResultList();
	}

	@GetMapping("/getEmplyeesWithNoName")
	public List<Employee> getEmplyeesWithNoName() {
		TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e where e.name = ''",
				Employee.class);
		return query.getResultList();
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return emsRepository.findAll();
	}

	@PostMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		int id = employee.getId();
		if (!emsRepository.existsById(id)) {

			emsRepository.saveAndFlush(employee);
			return "Employee Added";
		} else {
			throw new EmployeeAlreadyExistRuntimeException("Employee with this Id: " + id + " already present");
			// throw new RuntimeException("Employee with this Id: " + id + " already
			// present");
		}
	}

}
