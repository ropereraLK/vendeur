package io.github.ropereralk.vendeur.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    @JsonProperty("username")
    @NotBlank(message = "Mandatory Field is missing")
    @Size(min = 6, max = 20, message = "Must be between 6 and 20 characters")
    private String u1;

    @JsonProperty("password")
    @NotBlank(message = "Mandatory Field is missing")
    @Size(min = 8, max = 25, message = "Must be between 8 and 25 characters")
    private String p1;

    public LoginRequest(String u1, String p1) {
        this.u1 = u1;
        this.p1 = p1;
    }

    public LoginRequest() {
    }

    public String getU1() {
        return u1;
    }

//    public void setU1(String u1) {
//        this.u1 = u1;
//    }

    public String getP1() {
        return p1;
    }

//    public void setP1(String p1) {
//        this.p1 = p1;
//    }
}
