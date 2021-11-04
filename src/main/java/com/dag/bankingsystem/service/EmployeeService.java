package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.EmployeeDto;
import com.dag.bankingsystem.model.entity.Employee;
import com.dag.bankingsystem.model.request.employee.CreateEmployeeRequest;
import com.dag.bankingsystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.EmployeeMapper.EMPLOYEE_MAPPER;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(CreateEmployeeRequest createEmployeeRequest){
        Employee employee = EMPLOYEE_MAPPER.createEmployee(createEmployeeRequest);
        return EMPLOYEE_MAPPER.convertToEmployeeDto(employeeRepository.save(employee));
    }

    private Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElseThrow(()->new NotFoundException("Employee cannot be found"));
    }
    public EmployeeDto firedEmployee(int id){
        Employee employee = getEmployeeById(id);
        employee.setFired(true);
        return EMPLOYEE_MAPPER.convertToEmployeeDto(employeeRepository.save(employee));
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }

    public EmployeeDto getEmployee(int id){
        return EMPLOYEE_MAPPER.convertToEmployeeDto(getEmployeeById(id));
    }
}
