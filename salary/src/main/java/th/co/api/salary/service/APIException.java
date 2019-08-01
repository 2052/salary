package th.co.api.salary.service;

import org.springframework.http.HttpStatus;

public class APIException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int httpStatus = HttpStatus.OK.value();
	private ErrorMessage errorMessage;

	public APIException(int httpStatus, ErrorMessage errorMessage) {
		super(errorMessage.getResultDescription());
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
	}

	public APIException(int httpStatus, ErrorMessage errorMessage,
			Throwable cause) {
		super(errorMessage.getResultDescription(), cause);
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
	}
	
	public ErrorMessage getErrorMessage() {
		return this.errorMessage;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	public static APIException error400BadRequest(ErrorMessage errorMessage) {
		return new APIException(HttpStatus.BAD_REQUEST.value(), errorMessage);
	}


}
