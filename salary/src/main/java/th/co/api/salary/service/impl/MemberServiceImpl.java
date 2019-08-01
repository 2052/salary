package th.co.api.salary.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import th.co.api.salary.model.MemberModel;
import th.co.api.salary.model.rest.RegisterModelRequest;
import th.co.api.salary.model.rest.RegisterModelResponse;
import th.co.api.salary.repository.MemberRepository;
import th.co.api.salary.service.APIException;
import th.co.api.salary.service.APIExceptionCode;
import th.co.api.salary.service.ErrorMessage;
import th.co.api.salary.service.MemberService;
import th.co.api.salary.validation.RegisterValidator;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	RegisterValidator registerValidator;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Value("${salary.platinum}")
	private Integer platinum;
	
	@Value("${salary.gold.max}")
	private Integer goldMax;
	
	@Value("${salary.gold.mix}")
	private Integer goldMin;
	
	@Value("${salary.silver}")
	private Integer silver;

	@Override
	public RegisterModelResponse registerUser(RegisterModelRequest userRequest) throws APIException {

		ErrorMessage error = new ErrorMessage();
		RegisterModelResponse memberResponse  = new RegisterModelResponse();
		try {
			// validation parameter
			registerValidator.validate(userRequest);
			
			//check Username DataExist
			Integer countUsername = memberRepository.countByUsername(userRequest.getUsername());
			if (countUsername > 0) {
				throw APIException.error400BadRequest(new ErrorMessage(APIExceptionCode.STATUS_DATA_EXISTED.getResultCode(),APIExceptionCode.STATUS_DATA_EXISTED.getResultDescription() + " Username Duplicate"));
			}
			//check phone DataExist
			Integer countPhone = memberRepository.countByPhone(userRequest.getPhone());
			if (countPhone > 0) {
				throw APIException.error400BadRequest(new ErrorMessage(APIExceptionCode.STATUS_DATA_EXISTED.getResultCode(),APIExceptionCode.STATUS_DATA_EXISTED.getResultDescription() + " Phone Duplicate"));
			}
			
			//set value Request
			userRequest.setCreated(new Date()); //set value insert User Request
			MemberTypeClassify(userRequest); //Set Member Type to userRequest
			
			//Model Insert To Database
			MemberModel memberModel = new MemberModel();
			memberModel.setUsername(userRequest.getUsername());
			memberModel.setPassword(bcryptEncoder.encode(userRequest.getPassword()));
			memberModel.setAddress(userRequest.getAddress());
			memberModel.setCreated(userRequest.getCreated());
			memberModel.setMemberType(userRequest.getMemberType());
			memberModel.setPhone(userRequest.getPhone());
			memberModel.setSalary(userRequest.getSalary());
			memberModel.setRegisterRef(userRequest.getRegisterRef());
			
			MemberModel memberReturnBase = memberRepository.save(memberModel);
			
			//set response 
			memberResponse.setUsername(memberReturnBase.getUsername());
			memberResponse.setMemberType(memberReturnBase.getMemberType());
			memberResponse.setAddress(memberReturnBase.getAddress());
			memberResponse.setPhone(memberReturnBase.getPhone());
			memberResponse.setRegisterRef(memberReturnBase.getRegisterRef());
			memberResponse.setCreated(memberReturnBase.getCreated());
			memberResponse.setUpdated(memberReturnBase.getUpdated());

		} catch (RuntimeException e) {
			error.setResultCode(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultCode());
			error.setResultDescription(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultDescription());
		}

		return memberResponse;
	}
	
	public void MemberTypeClassify(RegisterModelRequest userRequest) throws APIException {

		ErrorMessage error = new ErrorMessage();
		String memberType = "";
		try {
			int salary = userRequest.getSalary();

			if (salary > platinum) {
				memberType = "Platinum";
			} else if (salary >= goldMin && salary <= goldMax) {
				memberType = "Gold";
			} else if (salary < silver) {
				memberType = "Silver";
			}
			
			//set Member Type 
			userRequest.setMemberType(memberType);

		} catch (RuntimeException e) {
			error.setResultCode(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultCode());
			error.setResultDescription(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultDescription());
		}

	}

	@Override
	public RegisterModelResponse getMemberInformation(String username) throws APIException {
		
		ErrorMessage error = new ErrorMessage();
		RegisterModelResponse memberResponse  = new RegisterModelResponse();
		try {
			
			MemberModel member = memberRepository.findByUsername(username);
			
			if (member == null) {
				throw APIException.error400BadRequest(new ErrorMessage(APIExceptionCode.STATUS_DATA_NOT_FOUND.getResultCode(),APIExceptionCode.STATUS_DATA_NOT_FOUND.getResultDescription()));
			}
			
			//set response 
			memberResponse.setUsername(member.getUsername());
			memberResponse.setMemberType(member.getMemberType());
			memberResponse.setAddress(member.getAddress());
			memberResponse.setPhone(member.getPhone());
			memberResponse.setRegisterRef(member.getRegisterRef());
			memberResponse.setCreated(member.getCreated());
			memberResponse.setUpdated(member.getUpdated());
			
			
		} catch (RuntimeException e) {
			error.setResultCode(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultCode());
			error.setResultDescription(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultDescription());
		}
		return memberResponse;
	}

}
