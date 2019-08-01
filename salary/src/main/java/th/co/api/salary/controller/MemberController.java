package th.co.api.salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.api.salary.model.rest.RegisterModelRequest;
import th.co.api.salary.model.rest.RegisterModelResponse;
import th.co.api.salary.service.APIException;
import th.co.api.salary.service.MemberService;

@RestController
@CrossOrigin
@RequestMapping("member")
public class MemberController extends AbstractRestController {
	
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegisterModelResponse registerMember(@RequestBody RegisterModelRequest userRequest) throws APIException {
		return memberService.registerUser(userRequest);
	}
	
	@RequestMapping(value = "/getInformation/{username}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public RegisterModelResponse getMemberInfomation(@PathVariable String username) throws APIException {
		return memberService.getMemberInformation(username);
	}
	

}
