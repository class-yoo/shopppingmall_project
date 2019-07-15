package com.cafe24.shoppingmall.validator.constraint.user;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shoppingmall.validator.user.UserIdValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = UserIdValidator.class)
public @interface ValidUserId {
	
	// 결과에대한 출력메세지
	String message() default "아이디를 다시입력 해주세요!! 아이디는 4-12자 영어로만 이루어져야 합니다.";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}


