package th.co.api.salary.service;

import org.springframework.stereotype.Service;

import th.co.api.salary.model.rest.RegisterModelRequest;
import th.co.api.salary.model.rest.RegisterModelResponse;

@Service
public interface MemberService {

	RegisterModelResponse registerUser(RegisterModelRequest userRequest) throws APIException;
	
	void MemberTypeClassify(RegisterModelRequest user) throws APIException;
	
	RegisterModelResponse getMemberInformation(String username) throws APIException;

}
