package com.spring.microservice.model.response;

public enum ErrorMessages {
	Missing_Requered_Field_Error("Missing required field. Please check your input data or the documentation."),
	Record_Already_Exists("Record Already Exists"),
	No_Record_Found("No record found"),
	Internal_Server_Error("Internal Server Error"),
	Authentication_Failed("Authentication Failed");
	
	
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
