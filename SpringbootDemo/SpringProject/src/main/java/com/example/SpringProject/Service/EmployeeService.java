package com.example.SpringProject.Service;

import com.example.SpringProject.DTO.EmployeeDTO;
import com.example.SpringProject.DTO.EmployeeSaveDTO;
import com.example.SpringProject.DTO.EmployeeUpdateDTO;
import com.example.SpringProject.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    String addEmployee(EmployeeSaveDTO employeeSaveDTO);
    List<EmployeeDTO> getAllEmployee();
    Optional<Employee> getEmployeeById(int id);

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);
}
