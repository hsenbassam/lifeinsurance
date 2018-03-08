package com.lifeinsurance.model;

import java.util.List;

public class JwtUser {
    private String userName;
    private long id;
    private List<String> role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public List<String> getRole() {
        return role;
    }
}
