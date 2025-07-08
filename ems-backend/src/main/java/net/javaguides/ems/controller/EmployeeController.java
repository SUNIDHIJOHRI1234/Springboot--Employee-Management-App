package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {


    private EmployeeService employeeService;


    // BUILD ADD EMPLOYEE REST API//

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployees = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    // BUILD GET EMPLOYEE REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build GET ALL EMPLOYEES REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }

    //BUILD UPDATE EMPLOYEE REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId,
                                                       @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployees(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }


    //BUILD DELETE EMPLOYEE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("employee deleted successfully!!");

    }
}















