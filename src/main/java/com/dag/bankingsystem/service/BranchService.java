package com.dag.bankingsystem.service;

import com.dag.bankingsystem.model.dto.AddressDto;
import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.dto.EmployeeDto;
import com.dag.bankingsystem.model.entity.Branch;
import com.dag.bankingsystem.model.entity.Credit;
import com.dag.bankingsystem.model.entity.Employee;
import com.dag.bankingsystem.model.request.branch.CreateBranchRequest;
import com.dag.bankingsystem.model.request.branch.UpdateBranchRequest;
import com.dag.bankingsystem.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static com.dag.bankingsystem.model.mapper.AddressMapper.ADDRESS_MAPPER;
import static com.dag.bankingsystem.model.mapper.BranchMapper.BRANCH_MAPPER;
import static com.dag.bankingsystem.model.mapper.CreditMapper.CREDIT_MAPPER;
import static com.dag.bankingsystem.model.mapper.EmployeeMapper.EMPLOYEE_MAPPER;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public BranchDto createBranch(CreateBranchRequest createBranchRequest){
        Branch branch = BRANCH_MAPPER.createBranch(createBranchRequest);
        return BRANCH_MAPPER.convertToBranchDto(branchRepository.save(branch));
    }

    public AddressDto getAddress(int id){
        Branch branch = getBranchById(id);
        return ADDRESS_MAPPER.convertToAddressDto(branch.getAddress());
    }

    public List<CreditDto> getCredits(int id){
        Branch branch = getBranchById(id);
        return CREDIT_MAPPER.convertToCreditDtoList(branch.getCredits());
    }

    public CreditDto getCreditByCreditId(int id,int creditId){
        Branch branch = getBranchById(id);
        Credit credit =branch.getCredits().stream().filter(index -> index.getId()==creditId).findAny().orElseThrow(()->new NotFoundException("Credit cannot be found"));
        return CREDIT_MAPPER.convertToCreditDto(credit);
    }
    public List<EmployeeDto> getFiredEmployees(int id){
        Branch branch = getBranchById(id);
        List<Employee> firedEmployees = branch.getEmployees().stream().filter(Employee::isFired).collect(Collectors.toList());
        return EMPLOYEE_MAPPER.convertToEmployeeDtoList(firedEmployees);
    }
    public List<EmployeeDto> getAllEmployees(int id){
        Branch branch = getBranchById(id);
        return EMPLOYEE_MAPPER.convertToEmployeeDtoList(branch.getEmployees());
    }
    public List<EmployeeDto> getNotFiredEmployees(int id){
        Branch branch = getBranchById(id);
        List<Employee> firedEmployees = branch.getEmployees().stream().filter(employee -> !employee.isFired()).collect(Collectors.toList());
        return EMPLOYEE_MAPPER.convertToEmployeeDtoList(firedEmployees);
    }
    public BranchDto updateBranch(int id,UpdateBranchRequest updateBranchRequest){
        Branch branch = getBranchById(id);
        BRANCH_MAPPER.updateBranch(branch,updateBranchRequest);
        return BRANCH_MAPPER.convertToBranchDto(branchRepository.save(branch));
    }
    private Branch getBranchById(int id){
        return branchRepository.findById(id).orElseThrow(()->new NotFoundException("Branch is not found"));
    }
    public void deleteBranch(int id){
        branchRepository.deleteById(id);
    }

    public BranchDto getBranch(int id){
        return BRANCH_MAPPER.convertToBranchDto(getBranchById(id));
    }

}
