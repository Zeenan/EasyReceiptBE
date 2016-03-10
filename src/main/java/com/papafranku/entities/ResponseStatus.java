package com.papafranku.entities;

import java.util.List;

public class ResponseStatus {
	
	private Integer code = null;
    private Integer status = null;
    private String msg = null;
    private String action = null;
    private Long count = null;
    private List results = null;
    private String error = null;
    
    
    
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
