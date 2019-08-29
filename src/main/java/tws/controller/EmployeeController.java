package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    
    @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 public void addEmployee(@RequestBody Employee employee) {
		 employeeMapper.insertEmpployee(employee);
	 }
    
//    @GetMapping
//	 @ResponseStatus(HttpStatus.OK)
//	 public List<Employee> getEmployee() {
//		 List<Employee> employee = employeeMapper.selectAll();
//		 return employee;
//	 }	 	 
	 
	 @PutMapping("/{id}")
	 @ResponseStatus(HttpStatus.OK)
	 public void updateEmployee(@RequestBody Employee employee) {	
		  employeeMapper.updateEmpployees(employee);
			 
		
	 }

	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.OK)
	 public void deleteEmployee(@PathVariable int id) {	
		 employeeMapper.deleteEmpployees(id);
	 }	

}
