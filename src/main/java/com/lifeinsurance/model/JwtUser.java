package com.lifeinsurance.model;

import java.util.List;

public class JwtUser {
    private String email;
    private long id;
    private List<String> role;
    

    public JwtUser() {
		super();
	}

	public JwtUser(String email, long id, List<String> role) {
		super();
		this.email = email;
		this.id = id;
		this.role = role;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public List<String> getRole() {
        return role;
    }
}
