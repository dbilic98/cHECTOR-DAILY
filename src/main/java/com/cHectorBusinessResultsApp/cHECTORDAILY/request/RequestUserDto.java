package com.cHectorBusinessResultsApp.cHECTORDAILY.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestUserDto {

    @NotBlank(message = "Username is mandatory")
    @Size(min = 5, max = 20, message = "Name should be at least 5 characters, and should not exceed 20 characters.")
    private String username;
    @NotBlank(message = "Email is mandatory")
    @Size(min = 7, max = 50, message = "Email should be at least 7 characters, and should not exceed 50 characters.")
    private String email;

    @NotBlank(message = "Phone is mandatory")
    @Size(min = 7, max = 50, message = "Phone should be at least 7 characters, and should not exceed 50 characters.")
    private String phone;

    public RequestUserDto(String username,String email,String phone){
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
