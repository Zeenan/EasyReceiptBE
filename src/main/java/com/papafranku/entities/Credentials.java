package com.papafranku.entities;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Credentials extends ResponseStatus implements Serializable {
	
	private String authenticity_token = null; //session token
	private String username = null;
    private String password = null;
    
    
    public Credentials() {
    	super();
    }
    
    public Credentials(String authenticity_token) {
        super();
        this.authenticity_token = authenticity_token;
    }
    
    public Credentials(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
    public Credentials(String username, String password, String authenticity_token) {
        super();
        this.username = username;
        this.password = password;
        this.authenticity_token = authenticity_token;
    }

	public String getauthenticity_token() {
		return authenticity_token;
	}
	public void setauthenticity_token(String authenticity_token) {
		this.authenticity_token = authenticity_token;
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
