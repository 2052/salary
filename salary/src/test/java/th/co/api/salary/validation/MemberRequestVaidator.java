package th.co.api.salary.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import th.co.api.salary.model.rest.RegisterModelRequest;
import th.co.api.salary.service.APIException;
import th.co.api.salary.service.APIExceptionCode;
import th.co.api.salary.service.ErrorMessage;

public class MemberRequestVaidator {

	@Autowired
	RegisterValidatorTest registerValidatorTest;
	
	@Test
	public void UsernamePass() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("[UsernamePass] value Username : " + requestModel.getUsername());
		assertTrue(check);
	}
	
	
	@Test
	public void UsernameFail() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		String message = null;
		try {
			requestModel.setUsername("");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			check = false;
			message = e.getMessage();
			assertThat(e.getMessage().toLowerCase())
						.isEqualTo((APIExceptionCode.STATUS_INVALID.getResultDescription() + " Username").toLowerCase());
		}
		assertFalse(check);
		System.out.println("[UsernameFail] value Username : " + requestModel.getUsername() + ", ErrorMessage : " +message);
	}
	
	
	@Test
	public void PasswordPass() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("[PasswordPass] value Password : " + requestModel.getPassword());
		assertTrue(check);
	}
	
	
	@Test
	public void PasswordFail() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		String message = null;
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			check = false;
			message = e.getMessage();
			assertThat(e.getMessage().toLowerCase())
						.isEqualTo((APIExceptionCode.STATUS_INVALID.getResultDescription() + " Password").toLowerCase());
		}
		assertFalse(check);
		System.out.println("[PasswordFail] value Password : " + requestModel.getPassword() + ", ErrorMessage : " +message);
	}
	
	
	@Test
	public void AddressPass() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("[AddressPass] value Address : " + requestModel.getAddress());
		assertTrue(check);
	}
	
	
	@Test
	public void AddressFail() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		String message = null;
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			check = false;
			message = e.getMessage();
			assertThat(e.getMessage().toLowerCase())
						.isEqualTo((APIExceptionCode.STATUS_INVALID.getResultDescription() + " Address").toLowerCase());
		}
		assertFalse(check);
		System.out.println("[AddressFail] value Address : " + requestModel.getPassword() + ", ErrorMessage : " +message);
	}
	
	
	@Test
	public void PhonePass() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("[PhonePass] value Phone : " + requestModel.getPhone());
		assertTrue(check);
	}
	
	
	@Test
	public void PhoneFail() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		String message = null;
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			check = false;
			message = e.getMessage();
			assertThat(e.getMessage().toLowerCase())
						.isEqualTo((APIExceptionCode.STATUS_INVALID.getResultDescription() + " Phone").toLowerCase());
		}
		assertFalse(check);
		System.out.println("[PhoneFail] value Phone : " + requestModel.getPhone() + ", ErrorMessage : " +message);
	}
	
	
	@Test
	public void salaryPass() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("2726 xx xx xx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(50000);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("[salaryPass] value Salary : " + requestModel.getSalary());
		assertTrue(check);
	}
	
	
	@Test
	public void salaryNull() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		String message = null;
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("272 xx xxx xxx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(null);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			check = false;
			message = e.getMessage();
			assertThat(e.getMessage().toLowerCase())
						.isEqualTo((APIExceptionCode.STATUS_INVALID.getResultDescription() + " Salary").toLowerCase());
		}
		assertFalse(check);
		System.out.println("[salaryNull] value Salary : " + requestModel.getSalary() + ", ErrorMessage : " +message);
	}
	
	
	@Test
	public void salaryLogicMin15k() throws APIException{
		Boolean check = null;
		RegisterModelRequest requestModel = new RegisterModelRequest();
		String message = null;
		try {
			requestModel.setUsername("Username");
			requestModel.setPassword("password");
			requestModel.setAddress("272 xx xxx xxx");
			requestModel.setPhone("0835505282");
			requestModel.setSalary(14999);
			
			validate(requestModel);
			check = true;
		} catch (APIException e) {
			check = false;
			message = e.getMessage();
			assertThat(e.getMessage().toLowerCase())
						.isEqualTo((APIExceptionCode.STATUS_INVALID.getResultDescription() + " Salary can be entered not less than 15000").toLowerCase());
		}
		assertFalse(check);
		System.out.println("[salaryLogicMin15k] value Salary : " + requestModel.getSalary() + ", ErrorMessage : " +message);
	}
	
	
	//Logic Validation
	public void validate(RegisterModelRequest param) throws APIException {

		if (param == null) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription()
					));
		}

		if (param.getUsername() == null || "".equals(param.getUsername().trim())) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription() + " Username"
					));
		}

		if (param.getPassword() == null || "".equals(param.getPassword().trim())) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription() + " Password"
					));
		}

		if (param.getAddress() == null || "".equals(param.getAddress().trim())) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription() + " Address"
					));
		}
		
		if (param.getSalary() == null) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription() + " Salary"
					));
		}
		
		if (param.getSalary() == null) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription() + " Salary"
					));
		}
		
		if (param.getSalary() != null) {
			if (param.getSalary() < 15000) {
				throw APIException.error400BadRequest(
						new ErrorMessage(
								APIExceptionCode.STATUS_INVALID.getResultCode(),
								APIExceptionCode.STATUS_INVALID.getResultDescription() + " Salary can be entered not less than 15000"
						));
			}
		}

		if ((param.getPhone() == null) || ("".equals(param.getPhone().trim())) || (param.getPhone().length() > 10) || (param.getPhone().length() < 10)) {
			throw APIException.error400BadRequest(
					new ErrorMessage(
							APIExceptionCode.STATUS_INVALID.getResultCode(),
							APIExceptionCode.STATUS_INVALID.getResultDescription() + " Phone"
					));
		}

	}
	
}
