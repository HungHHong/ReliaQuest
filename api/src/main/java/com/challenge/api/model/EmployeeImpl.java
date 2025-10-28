package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

public class EmployeeImpl {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private Instant createdAt = Instant.now();

    public UUID getUuid() { return uuid; }
    public void setUuid(UUID uuid) { this.uuid = uuid; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
