package com.cafe24.shoppingmall.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.shoppingmall.validator.constraint.user.ValidUserId;

public class UserVo {
	
	private Long no;
	
	@ValidUserId
	private String id;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Pattern(regexp="(?=.*\\d{1,20})(?=.*[~`!@#$%\\^&*()-+=]{1,20})(?=.*[a-zA-Z]{2,20}).{8,20}$",
		message="비밀번호는 8자 이상 20자 이하의 숫자,특수문자 각 1회 이상, 영문 2개 이상 사용해야합니다") 
	@Length(min=8, max=20, message="비밀번호는 8자 이상 20자 이하로 입력해야 합니다.")
	private String password;
	
	private String role = "ROLE_USER";
	
	@NotEmpty
	@Length(min =2, max =8)
	private String name;
	
	@NotEmpty
	private String birth;
	
	@NotEmpty
	private String contact;
	
	@NotEmpty
	private String gender;
	private String isWithdrawal;

	public UserVo() {}
	
	public UserVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public UserVo(String id) {
		this.id = id;
	}
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIsWithdrawal() {
		return isWithdrawal;
	}

	public void setIsWithdrawal(String isWithdrawal) {
		this.isWithdrawal = isWithdrawal;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", birth="
				+ birth + ", contact=" + contact + ", gender=" + gender + ", isWithdrawal=" + isWithdrawal + "]";
	}

}
