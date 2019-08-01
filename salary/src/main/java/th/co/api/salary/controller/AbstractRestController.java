package th.co.api.salary.controller;


import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import th.co.api.salary.service.APIException;
import th.co.api.salary.service.APIExceptionCode;
import th.co.api.salary.service.ErrorMessage;


public class AbstractRestController {

private static final Logger logger = LoggerFactory.getLogger(AbstractRestController.class);
	
	
	@ExceptionHandler(APIException.class)
	public ErrorMessage handlerAPIException(APIException e, HttpServletResponse response) {
		logDetailAPIException(e);
		response.setStatus(e.getHttpStatus());
		return e.getErrorMessage();
	}
	
	private void logDetailAPIException(APIException e) {
		ErrorMessage errorMessage = e.getErrorMessage();
		if(e.getHttpStatus() == 500 && errorMessage != null) {
			// if 500 printStackTrace
			logger.error(e.getMessage(), e);
		} else {
			logger.warn(e.getMessage());
		}
		
		logger.debug(e.getMessage(), e);
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({BindException.class, 
		MethodArgumentNotValidException.class,
		MissingServletRequestParameterException.class,
		MissingServletRequestPartException.class,
		ServletRequestBindingException.class})
	public ErrorMessage handlerDefaultBadRequestException(Exception e) {
		logger.error(e.getMessage());
		logger.debug(e.getMessage(), e);
		ErrorMessage errorMessage = new ErrorMessage(APIExceptionCode.STATUS_INVALID.getResultCode(), APIExceptionCode.STATUS_INVALID.getResultDescription() +", "+ e.getMessage());
		return errorMessage;
	}
	

	
}
