package com.dag.bankingsystem.model.mapper;

import com.dag.bankingsystem.model.dto.EmployeeDto;
import com.dag.bankingsystem.model.entity.Employee;
import com.dag.bankingsystem.model.request.employee.CreateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee createEmployee(CreateEmployeeRequest createEmployeeRequest);

    @Mapping(source = "salaryAccount.iban",target = "salaryAccountIban")
    @Mapping(source = "branch.name",target = "branchName")
    EmployeeDto convertToEmployeeDto(Employee employee);

    List<EmployeeDto> convertToEmployeeDtoList(List<Employee> employees);
}
