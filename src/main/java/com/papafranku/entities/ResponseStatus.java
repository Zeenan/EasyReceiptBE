package com.papafranku.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonInclude(Include.NON_NULL)
public class ResponseStatus {
	
	private Integer code = null;
    private Integer status = null;
    private String msg = null;
    private String action = null;
    private Long count = null;
    private List results = null;
    private String error = null;
    
    public ResponseStatus() {
    	super();
    }
    
    public ResponseStatus(Integer code) {
        super();
        this.code = code;
    }
    
    public ResponseStatus(String msg) {
        super();
        this.msg = msg;
    }
    
    public ResponseStatus(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    
    public ResponseStatus(Long count, List results) {
        super();
        this.count = count;
        this.results = results;
    }
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List getResults() {
		return results;
	}
	public void setResults(List results) {
		this.results = results;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
    
    

}
