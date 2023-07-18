package com.cHectorBusinessResultsApp.cHECTORDAILY.controller.response;

import java.util.UUID;

public class ResponseUserDto {
    private UUID id;
    private String username;
    private String email;
    private String phone;

    public ResponseUserDto(UUID id,String username, String email, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
