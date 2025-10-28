package com.challenge.api.service;
import com.challenge.api.model.EmployeeImpl;
import java.util.*;

    /**
     * Service layer responsible for handling all Employee related operations.
     *
     * TODO:
     *  - Store employees in a local in-memory data structure
     *  - Implement methods to:
     *      1. getAllEmployees()
     *      2. getEmployeeByUuid(UUID uuid)
     *      3. createEmployee(EmployeeImpl employee)
     *
     * This class will later be used by EmployeeController to perform CRUD operations.
     */

public class EmployeeService {
    private final Map<UUID, EmployeeImpl> employeeStore = new HashMap<>();

    public List<EmployeeImpl> getAllEmployees() {
        return new ArrayList<>(employeeStore.values());
    }

    public EmployeeImpl getEmployeeByUuid(UUID uuid) {
        return employeeStore.get(uuid);
    }

    public EmployeeImpl createEmployee(EmployeeImpl employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        employeeStore.put(employee.getUuid(), employee);
        return employee;
    }

}
