package com.codeclan.example.employeeservice;

import com.codeclan.example.employeeservice.models.Department;
import com.codeclan.example.employeeservice.models.Employee;
import com.codeclan.example.employeeservice.models.Project;
import com.codeclan.example.employeeservice.repositories.DepartmentRepository;
import com.codeclan.example.employeeservice.repositories.EmployeeRepository;
import com.codeclan.example.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department hr = new Department("HR");
		departmentRepository.save(hr);

		Employee sergei = new Employee("Sergei", "Poliivov", 32,
				2213, "sergei.workaholic@sminoff.rs", hr);
		employeeRepository.save(sergei);
	}

	@Test
	public void addEmployeeAndProject(){
		Department hr = new Department("HR");
		departmentRepository.save(hr);

		Employee sergei = new Employee("Sergei", "Poliivov", 32,
				2213, "sergei.workaholic@sminoff.rs", hr);
		employeeRepository.save(sergei);

		Project codeclan = new Project("PSD", 4);

		codeclan.addEmployee(sergei);
		projectRepository.save(codeclan);
	}



}
