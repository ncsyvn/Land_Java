package com.nguyencongsy.models.request;

public class Response<T> {
	public int Code;
	public String Message;
	public T Data;
	public Response() {};
	public Response(int code, String message, T data) {
		this.Code = code;
		this.Message = message;
		this.Data = data;
	}
	
}
