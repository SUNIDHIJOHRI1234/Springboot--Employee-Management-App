package net.javaguides.ems.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotfoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRespository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRespository employeeRespository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
    Employee savedEmployee =    employeeRespository.save(employee);
    return EmployeeMapper.maptoEmployeeDto (savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotfoundException("Employee does not exist with given id: " + employeeId));

        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRespository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee))
                .collect(Collectors.toList());


        }

    @Override
    public EmployeeDto updateEmployees(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee =employeeRespository.findById(employeeId).orElseThrow(
                () -> new ResourceNotfoundException("Employee is not exists withgiven id:" + employeeId )

        );
employee.setFirstName(updatedEmployee.getFirstName());
employee.setLastName(updatedEmployee.getLastName());
employee.setEmail(updatedEmployee.getEmail());

Employee updatedEmployeeObj =employeeRespository.save(employee);

        return EmployeeMapper.maptoEmployeeDto(updatedEmployeeObj) ;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =employeeRespository.findById(employeeId).orElseThrow(
                () -> new ResourceNotfoundException("Employee is not exists withgiven id:" + employeeId )

        );
employeeRespository.deleteById(employeeId);
    }
}



