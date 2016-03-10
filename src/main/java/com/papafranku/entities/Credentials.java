package com.papafranku.entities;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Credentials extends ResponseStatus implements Serializable {
	
	private String accessToken = null;
	private String username = null;
    private String password = null;
    
    
    public Credentials() {
    	super();
    }
    
    public Credentials(String accessToken) {
        super();
        this.accessToken = accessToken;
    }
    
    public Credentials(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
    public Credentials(String username, String password, String accessToken) {
        super();
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
    }

	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
