package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.EmployeeDto;
import com.dag.bankingsystem.model.request.employee.CreateEmployeeRequest;
import com.dag.bankingsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("{id}")
    public EmployeeDto getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return employeeService.createEmployee(createEmployeeRequest);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestParam int id){
        employeeService.deleteEmployee(id);
    }

    @DeleteMapping("fire")
    public EmployeeDto fireEmployee(@RequestParam int id){
        return employeeService.firedEmployee(id);
    }
}
