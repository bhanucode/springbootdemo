package com.genpact.demoApp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.demoApp.Model.Employee;

@RestController
public class HelloWorldController {

	private List<Employee> employeeList = new ArrayList<Employee>();

	@PostConstruct
	private void initEmployeeList() {
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

	}

	@GetMapping("/employeeList")
	public List<Employee> getEmployeeList() {

		return employeeList;
	}

	@GetMapping("/employeeById/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {

		for (Employee emp : employeeList) {

			if (emp.getId() == empId) {
				return emp;
			}
		}

		return new Employee();

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public List<Employee> addEmployee(@RequestBody Employee emp) throws EmployeeAlreadyExistsException {

		/*
		 * for (Employee e : employeeList) { if (e.getId() == emp.getId()) {
		 * throw new EmployeeAlreadyExistsException(); } }
		 */

		// employeeList.add(emp);

		// return emp.getId();

		employeeList.add(emp);

		return employeeList;
	}
	
	@RequestMapping(value = "/update/{empId}", method = RequestMethod.PUT, consumes = "application/json")
	public Employee updateEmployee(@PathVariable int empId ,@RequestBody Employee emp){			
		
		for (Employee e:employeeList){
		//if(empId < employeeList.size() && (emp = getEmployeeById(empId)) != null)
		if(e.getId()==emp.getId())	{ 
		e.setName(emp.getName());
		e.setAge(emp.getAge());
		e.setDepartment(emp.getDepartment());
		e.setGender(emp.getGender());
		e.setYearOfJoining(emp.getYearOfJoining());
		e.setSalary(emp.getSalary());  
		}
		}
		return emp;
	}

	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.DELETE)
	public Employee removeEmployee(@PathVariable int empId) {
		Employee emp = null;
		if ((emp = getEmployeeById(empId)) != null) {
			employeeList.remove(emp);
			return emp;
		}
		return null;
	}
	
	

	@RequestMapping("/")
	public String hello() {
		return "Welcome to Genpact India";
	}

	@GetMapping("/hello")
	public String gethelloRequest() {
		return "Hello User, have a nice day.";
	}

	@GetMapping("/hello/{email}")
	public String gethelloPathRequest(@PathVariable String email) {
		return "your successfully register";
	}

	@GetMapping("/helloRequest")
	public String gethelloRequestParam(@RequestParam String email, @RequestParam String phone) {
		return "your successfully enter ur data";
	}

}
