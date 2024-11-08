package io.github.ropereralk.vendeur.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class UserApiDTO {

    private String userId;
    private String firstName;
    private String lastName;
    @JsonProperty("username")
    private String u1;
    @JsonProperty("password")
    private String p1;
    private String employeeId;
    private String identityNumber;
    private String email;
    private boolean isActive = false;
    private ArrayList<String> roles;

    public UserApiDTO() {
    }

    public UserApiDTO(String userId, String firstName, String lastName, String u1, String p1, String employeeId, String identityNumber, String email, boolean isActive, ArrayList<String> roles) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.u1 = u1;
        this.p1 = p1;
        this.employeeId = employeeId;
        this.identityNumber = identityNumber;
        this.email = email;
        this.isActive = isActive;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
}
