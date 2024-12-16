package base.controller;

import base.entity.Employee;
import base.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String test() {
        return "Application Up and running";
    }

    @PostMapping("/saveOrUpdate")
    public Employee saveOrUpdateEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        Employee employee = employeeRepo.findById(id).orElse(null);

        if (employee == null)
            return "Employee not found with ID: " + id;

        employeeRepo.delete(employee);
        return "Employee deleted successfully with ID: " + id;
    }

    @GetMapping("/get/{id}")
    public String findEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        return employee == null ?
                "Employee not found with ID: " + id :
                employee.toString();
    }

    @GetMapping("/get")
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

}
