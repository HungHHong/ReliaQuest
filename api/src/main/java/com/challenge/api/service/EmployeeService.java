package com.challenge.api.service;

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
