package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;


    /**
     * Implementation of the {@link Employee} interface.
     * Represents an employee record used by the service and controller layers,
     * serialize to and from JSON for the REST API.
     */

    public class EmployeeImpl implements Employee {

        private UUID uuid;
        private String firstName;
        private String lastName;
        private String fullName;
        private Integer salary;
        private Integer age;
        private String jobTitle;
        private String email;
        private Instant contractHireDate;
        private Instant contractTerminationDate;
        private Instant createdAt = Instant.now();

        /** No-args constructor for JSON deserialization */
        public EmployeeImpl() {}

        /** Convenience constructor for creating mock data */
        public EmployeeImpl(UUID uuid, String firstName, String lastName,
                            Integer salary, Integer age, String jobTitle, String email,
                            Instant contractHireDate, Instant contractTerminationDate) {

            this.uuid = uuid;
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = firstName + " " + lastName;
            this.salary = salary;
            this.age = age;
            this.jobTitle = jobTitle;
            this.email = email;
            this.contractHireDate = contractHireDate;
            this.contractTerminationDate = contractTerminationDate;
        }


        // --------------------------------------------------------
        // Interface Implementation
        // --------------------------------------------------------

        @Override
        public UUID getUuid() { return uuid; }

        @Override
        public void setUuid(UUID uuid) { this.uuid = uuid; }

        @Override
        public String getFirstName() { return firstName; }

        @Override
        public void setFirstName(String name) {
            this.firstName = name;
            this.fullName = (this.lastName != null) ? this.firstName + " " + this.lastName : this.firstName;
        }

        @Override
        public String getLastName() { return lastName; }

        @Override
        public void setLastName(String name) {
            this.lastName = name;
            this.fullName = (this.firstName != null) ? this.firstName + " " + this.lastName : this.lastName;
        }

        @Override
        public String getFullName() { return fullName; }

        @Override
        public void setFullName(String name) { this.fullName = name; }

        @Override
        public Integer getSalary() { return salary; }

        @Override
        public void setSalary(Integer salary) { this.salary = salary; }

        @Override
        public Integer getAge() { return age; }

        @Override
        public void setAge(Integer age) { this.age = age; }

        @Override
        public String getJobTitle() { return jobTitle; }

        @Override
        public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

        @Override
        public String getEmail() { return email; }

        @Override
        public void setEmail(String email) { this.email = email; }

        @Override
        public Instant getContractHireDate() { return contractHireDate; }

        @Override
        public void setContractHireDate(Instant date) { this.contractHireDate = date; }

        @Override
        public Instant getContractTerminationDate() { return contractTerminationDate; }

        @Override
        public void setContractTerminationDate(Instant date) { this.contractTerminationDate = date; }

        public Instant getCreatedAt() { return createdAt; }

        public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

        @Override
        public String toString() {
            return String.format("EmployeeImpl[%s - %s (%s)]",
                    uuid,
                    fullName,
                    jobTitle);
        }
    }
