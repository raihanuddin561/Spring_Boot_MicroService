package com.spring.microservice.model.response;

public enum ErrorMessages {
	Missing_Requered_Field_Error("Missing required field. Please check your input data or the documentation.");
	
	private String errorMessage;
	 ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	

}
