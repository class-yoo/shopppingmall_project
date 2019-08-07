package com.cafe24.shoppingmall.controller.api;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/user")
public class UserAPIContoller {

//	@Autowired
//	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	/** TODO Message
	 * 
	 * 아이디 중복을 확인하는 메소드이며 String 형태의 id를 파라미터로받는다.
	 * 유효성검사를 실시한다.
	 */
	@ApiOperation(value = "아이디 존재 여부")
	@RequestMapping(value = "/checkid/{id}", method = RequestMethod.GET)
	public ResponseEntity<JSONResult> checkId(@PathVariable(value = "id") String id) {
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(new UserVo(id), "id");
		
		HttpStatus status = HttpStatus.OK;
		String message = null;
		JSONResult jsonResult = JSONResult.success(true);
		
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults ) {
				message = validatorResult.getMessage();
				status = HttpStatus.OK;
				jsonResult = JSONResult.fail(message);
				return makeResponseEntity(status, jsonResult);
			}
		}
		
		boolean overlapCheckResult = userService.checkOverapId(id);
		if(overlapCheckResult) {
			message = "중복된 아이디가 있습니다.";
			status = HttpStatus.OK;
			jsonResult = JSONResult.fail(message);
		}
		return makeResponseEntity(status, jsonResult);
	}
	
	/** TODO Message
	 * 
	 * 회원정보를 등록하는 메소드이면 회원객체인 UserVo와 유효성검사 결과가 저장되는 BindingResult 객체를 파라미터로 받는다.
	 * 유효성검사를 실시한다.
	 */
	@ApiOperation(value = "회원가입")
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> join(@RequestBody UserVo userVo , BindingResult result) {
		
		System.out.println(userVo);
		HttpStatus status = HttpStatus.OK;
		JSONResult jsonResult = JSONResult.success(true);
		String message = null;
		
		if( result.hasErrors() ) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				status = HttpStatus.OK;
				message = error.getDefaultMessage();
				jsonResult = JSONResult.fail(message);
				return makeResponseEntity(status, jsonResult);
			}
		}
		
		boolean emailOverlapCheckResult = userService.join(userVo);
		if(!emailOverlapCheckResult) {
			status = HttpStatus.OK;
			message = "회원가입에 실패하였습니다.";
			jsonResult = JSONResult.fail(message);
		}
		
		return makeResponseEntity(status, jsonResult);
	}
	
	/** TODO Message
	 * 
	 * 회원정보를 등록하는 메소드이면 회원객체인 UserVo와 유효성검사 결과가 저장되는 BindingResult 객체를 파라미터로 받는다.
	 * 유효성검사를 실시한다.
	 */
	@ApiOperation(value = "로그인")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
		
		HttpStatus status = HttpStatus.OK;
		String message = null;
		JSONResult jsonResult = null;
		
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults ) {
				message = validatorResult.getMessage();
				status = HttpStatus.OK;
				jsonResult = JSONResult.fail(message);
				return makeResponseEntity(status, jsonResult);
			}
		}
		
		UserVo loginUserVo = userService.login(userVo);
		jsonResult = JSONResult.success(loginUserVo);
		
		return makeResponseEntity(status, jsonResult);

	}
	
	public ResponseEntity<JSONResult> makeResponseEntity(HttpStatus status, JSONResult jsonResult){
		return ResponseEntity.status(status).body(jsonResult);
	}
}
