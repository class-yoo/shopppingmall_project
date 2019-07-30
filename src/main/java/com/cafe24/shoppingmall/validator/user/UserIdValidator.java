package com.cafe24.shoppingmall.validator.user;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.cafe24.shoppingmall.validator.constraint.user.ValidUserId;

public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

	// 4 - 12 글자이며 영어 대소문자로 이루어져야함  
	private Pattern pattern = Pattern.compile("^[a-zA-Z]{4,12}$");
	
	public void initialize(ValidUserId constraintAnnotation) {
	}
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0 || "".contentEquals(value)) {
			return false;
		}
		return pattern.matcher(value).matches();
	}

}

