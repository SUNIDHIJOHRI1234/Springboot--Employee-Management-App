package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

// This class handles mapping between Employee entity and EmployeeDto
public class EmployeeMapper {


    /**
     * Converts an Employee entity object to an EmployeeDto.
     *
     * @param employee the Employee entity to convert
     * @return a DTO object containing employee details
     */

    public static EmployeeDto maptoEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

    }

    /**
     * Converts an EmployeeDto object to an Employee entity.
     *
     * @param employeeDto the DTO object to convert
     * @return an Employee entity object
     */


    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}

