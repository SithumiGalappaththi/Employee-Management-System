package com.example.SpringProject.Controller;

import com.example.SpringProject.DTO.EmployeeDTO;
import com.example.SpringProject.DTO.EmployeeSaveDTO;
import com.example.SpringProject.DTO.EmployeeUpdateDTO;
import com.example.SpringProject.Entity.Employee;
import com.example.SpringProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
        String id = employeeService.addEmployee(employeeSaveDTO);
        return id;
    }

    @GetMapping(path = "/getall")
    public List<EmployeeDTO> getAllEmployee()
    {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }

    @GetMapping(path = "{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") int id) {
        Optional<Employee> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO;
    }

    @PutMapping(path = "/update")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO)
    {
        String id = employeeService.updateEmployee(employeeUpdateDTO);
        return id;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id)
    {
        boolean deleteEmployee = employeeService.deleteEmployee(id);
        return "deleted";
    }
}
