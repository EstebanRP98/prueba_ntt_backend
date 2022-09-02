package com.erosero.bancontt.util;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


@Component
public class GenericResponse<T> implements Serializable {
	
	private static final long serialVersionUID = 4189541161407214791L;
	private Integer status;
	private String message;
	private String messageError;
	private T object;

	public void saveMessage(List<String> mensajeList){
		if(mensajeList.size()>1){
			message= mensajeList.get(0);
			messageError= mensajeList.get(1);
		}else{
			message= mensajeList.get(0);
		}
	}

	public Integer getStatus() {
		if (status == null) {
			status = ParametersApp.SUCCESSFUL.value();
		}
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		if(message==null && status != null) {
				message = ParametersApp.resolve(status).getReasonPhrase();
		}
		return message;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
