package com.challenge.api.service;

import com.challenge.api.model.EmployeeImpl;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

    /**
     * Handles core business logic for managing employees.
     * Stores employees in an in-memory map and provides simple CRUD-style methods.
     */

public class EmployeeService {
    private final Map<UUID, EmployeeImpl> employeeStore = new HashMap<>();

    /** Mock Data for testing purposes */
    public EmployeeService() {
        createEmployee(new EmployeeImpl(
                null, "Hong", "H", 85000, 30, "Software Engineer",
                "Hong.H@quest.com", Instant.now(), null));

        createEmployee(new EmployeeImpl(
                null, "Bob", "Johnson", 92000, 35, "DevOps Engineer",
                "bob.johnson@gmail.com", Instant.now(), null));
    }


    // --------------------------------------------------------
    // Implement required method
    // --------------------------------------------------------

    // return all employee currently store
    public List<EmployeeImpl> getAllEmployees() {
        return new ArrayList<>(employeeStore.values());
    }

    //retrieves employee by their unique UUID
    public EmployeeImpl getEmployeeByUuid(UUID uuid) {
        return employeeStore.get(uuid);
    }


    //Create and stores a new employee. Generates a UUID if doesn't exist
    public EmployeeImpl createEmployee(EmployeeImpl employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        employeeStore.put(employee.getUuid(), employee);
        return employee;
    }

}
