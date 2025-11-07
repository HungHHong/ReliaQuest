package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;


    /**
     * REST controller for Employee API.
     *
     * Exposes 3 endpoints:
     *  1. GET /api/employees         → getAllEmployees()
     *  2. GET /api/employees/{uuid}  → getEmployeeByUuid()
     *  3. POST /api/employees        → createEmployee()
     *
     * Notes:
     *  - Annotate with @RestController and @RequestMapping("/api/employees")
     *  - Inject EmployeeService via constructor
     */

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    //Inject EmployeeService
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    // return all employees system have
    @GetMapping
    public List<EmployeeImpl> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    // return single employee with UUID
    @GetMapping("/{uuid}")
    public EmployeeImpl getEmployeeByUuid(@PathVariable UUID uuid) {
        EmployeeImpl employee = employeeService.getEmployeeByUuid(uuid);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeImpl createEmployee(@RequestBody EmployeeImpl requestBody) {
        return employeeService.createEmployee(requestBody);
    }
}
