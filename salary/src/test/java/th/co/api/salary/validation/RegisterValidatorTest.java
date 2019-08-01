package th.co.api.salary.validation;

import org.springframework.stereotype.Service;

import th.co.api.salary.model.rest.RegisterModelRequest;
import th.co.api.salary.service.APIException;
import th.co.api.salary.service.APIExceptionCode;
import th.co.api.salary.service.ErrorMessage;

@Service("registerValidatorTest")
public class RegisterValidatorTest implements ValidatorTest<RegisterModelRequest> {

	@Override
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
