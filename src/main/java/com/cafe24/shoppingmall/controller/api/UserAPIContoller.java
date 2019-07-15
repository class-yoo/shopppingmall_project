package com.cafe24.shoppingmall.controller.api;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/user")
public class UserAPIContoller {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "이메일 존재 여부")
	@RequestMapping(value = "/checkid/{id}", method = RequestMethod.GET)
	public JSONResult checkId(@PathVariable(value = "id") String id) {

		boolean emailOverlapCheckResult = userService.checkOverapId(id);
		return JSONResult.success(emailOverlapCheckResult);
	}

	@ApiOperation(value = "회원가입")
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public JSONResult join(@RequestBody @Valid UserVo userVo) {

		boolean emailOverlapCheckResult = userService.join(userVo);

		return JSONResult.success(emailOverlapCheckResult);
	}

	@ApiOperation(value = "로그인")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {

		// 파라미터에 @Valid를 명시해주지 않고 유효성검사를 동적으로 생성해줘서 적용한다.
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		// UserVo의 email 필드에 선언된 validation만 적용한다.
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
		
		if (validatorResults.isEmpty() == false) {
			String message = messageSource.getMessage("Email.userVo.email", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}

		UserVo loginUserVo = userService.login(userVo);

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("loginSuccess"));

	}
}
