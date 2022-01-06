package com.henrique.helpdesk.services.execptions;

import java.util.ArrayList;
import java.util.List;

import com.henrique.helpdesk.resources.execeptions.StandardError;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ValidationError extends StandardError {
	
	public ValidationError(Long timestamp, Integer status, String error, String message, String path){
		super(timestamp, status, error, message, path);
	}

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();	
	
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
}
