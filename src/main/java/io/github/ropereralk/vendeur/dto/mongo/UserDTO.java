package io.github.ropereralk.vendeur.dto.mongo;

import io.github.ropereralk.vendeur.util.validator.enums.IdentityType;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

@Valid
@Document(collection = "user")
public class UserDTO {

    @Id
    private UUID userId;

    private String externalId;
    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    @NotBlank(message = "u1 is required")
    private String u1;

    @Indexed(unique = true)
    private String employeeId;

    private IdentityType identityType;
    private String identityNumber;


    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    @Indexed(unique = true)
    private String email;

    private boolean isActive = false;

    private ArrayList<String> roles;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    private Long version;

    public UserDTO() {
    }

    public UserDTO(UUID userId, String externalId, String firstName, String lastName, String u1, String employeeId, IdentityType identityType, String identityNumber, String email, boolean isActive, ArrayList<String> roles, Instant createdDate, Instant lastModifiedDate, Long version) {
        this.userId = userId;
        this.externalId = externalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.u1 = u1;
        this.employeeId = employeeId;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.email = email;
        this.isActive = isActive;
        this.roles = roles;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.version = version;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "u1 is required") String getU1() {
        return u1;
    }

    public void setU1(@NotBlank(message = "u1 is required") String u1) {
        this.u1 = u1;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email is not valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email is not valid") String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
