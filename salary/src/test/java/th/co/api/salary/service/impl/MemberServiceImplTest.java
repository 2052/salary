package th.co.api.salary.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import th.co.api.salary.model.rest.RegisterModelRequest;
import th.co.api.salary.service.APIException;
import th.co.api.salary.service.APIExceptionCode;
import th.co.api.salary.service.ErrorMessage;
import th.co.api.salary.service.MemberService;

public class MemberServiceImplTest {

	@Autowired
	MemberService memberService;
	
	
	@Test
	public void memberTypeGoldMaxTest() throws Exception {
		int salary = 50000;
		RegisterModelRequest regiserRequest = new RegisterModelRequest();
		regiserRequest.setSalary(salary);
		MemberTypeClassify(regiserRequest);
		System.out.println("[memberTypeGoldMaxTest] salary : " + salary +" MemberType : "+regiserRequest.getMemberType());
		assertThat(regiserRequest.getMemberType().toLowerCase()).isEqualTo("Gold".toLowerCase());

	}

	@Test
	public void memberTypeGoldTest() throws Exception {
		int salary = 40000;
		RegisterModelRequest regiserRequest = new RegisterModelRequest();
		regiserRequest.setSalary(salary);
		MemberTypeClassify(regiserRequest);
		System.out.println("[memberTypeGoldTest] salary : " + salary +" MemberType : "+regiserRequest.getMemberType());
		assertThat(regiserRequest.getMemberType().toLowerCase()).isEqualTo("Gold".toLowerCase());
	}

	@Test
	public void memberTypeGoldMinTest() throws Exception {
		int salary = 30000;
		RegisterModelRequest regiserRequest = new RegisterModelRequest();
		regiserRequest.setSalary(salary);
		MemberTypeClassify(regiserRequest);
		System.out.println("[memberTypeGoldMinTest] salary : " + salary +" MemberType : "+regiserRequest.getMemberType());
		assertThat(regiserRequest.getMemberType().toLowerCase()).isEqualTo("Gold".toLowerCase());
	}

	@Test
	public void memberTypePlatinumTest() throws Exception {
		int salary = 50001;
		RegisterModelRequest regiserRequest = new RegisterModelRequest();
		regiserRequest.setSalary(salary);
		MemberTypeClassify(regiserRequest);
		System.out.println("[memberTypePlatinumTest] salary : " + salary +" MemberType : "+regiserRequest.getMemberType());
		assertThat(regiserRequest.getMemberType().toLowerCase()).isEqualTo("Platinum".toLowerCase());
	}

	@Test
	public void memberTypeSilverTest() throws Exception {
		int salary = 29999;
		RegisterModelRequest regiserRequest = new RegisterModelRequest();
		regiserRequest.setSalary(salary);
		MemberTypeClassify(regiserRequest);
		System.out.println("[memberTypeSilverTest] salary : " + salary +" MemberType : "+regiserRequest.getMemberType());
		assertThat(regiserRequest.getMemberType().toLowerCase()).isEqualTo("Silver".toLowerCase());

	}

	public void MemberTypeClassify(RegisterModelRequest userRequest) throws APIException {
		ErrorMessage error = new ErrorMessage();
		String memberType = "";
		try {

			int salary = userRequest.getSalary();

			if (salary > 50000) {
				memberType = "Platinum";
			} else if (salary >= 30000 && salary <= 50000) {
				memberType = "Gold";
			} else if (salary < 30000) {
				memberType = "Silver";
			}

			// set Member Type
			userRequest.setMemberType(memberType);

		} catch (RuntimeException e) {
			error.setResultCode(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultCode());
			error.setResultDescription(APIExceptionCode.STATUS_SYSTEM_ERROR.getResultDescription());
		}

	}
}
