package com.example.SpringProject.Service;

import com.example.SpringProject.DTO.EmployeeDTO;
import com.example.SpringProject.DTO.EmployeeSaveDTO;
import com.example.SpringProject.DTO.EmployeeUpdateDTO;
import com.example.SpringProject.Entity.Employee;
import com.example.SpringProject.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {

        Employee employee = new Employee(
                employeeSaveDTO.getEmployeename(),
                employeeSaveDTO.getEmployeeaddress(),
                employeeSaveDTO.getMobile()
        );

        employeeRepo.save(employee);
        return employee.getEmployeename();

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<Employee> getEmployees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee e:getEmployees){
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    e.getEmployeeid(),
                    e.getEmployeename(),
                    e.getEmployeeaddress(),
                    e.getMobile()
            );
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> employeeDTO = employeeRepo.findById(id);
        return employeeDTO;
    }

    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        if(employeeRepo.existsById(employeeUpdateDTO.getEmployeeid())){
            Employee employee = employeeRepo.getById(employeeUpdateDTO.getEmployeeid());
            employee.setEmployeename(employeeUpdateDTO.getEmployeename());
            employee.setEmployeeaddress(employeeUpdateDTO.getEmployeeaddress());
            employee.setMobile(employeeUpdateDTO.getMobile());

            employeeRepo.save(employee);
        }

        else {
            System.out.println("employee id not found");
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
        }
        else {
            System.out.println("Employee id not found");
        }
        return true;
    }

}
