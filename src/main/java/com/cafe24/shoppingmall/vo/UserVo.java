package com.cafe24.shoppingmall.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	
	@NotEmpty
	@Length(min=4, max=20, message="아이디는 4자 이상 12자 이하로 입력해야 합니다.")
	private String id;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Pattern(regexp="(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}", message="비밀번호는 8자 이상 20자 이하의 알파벳, 숫자, 특수문자를 조합하여 작성해야 합니다.") 
	@Length(min=8, max=20, message="비밀번호는 8자 이상 20자 이하로 입력해야 합니다.")
	private String password;
	
	@NotEmpty
	@Length(min =2, max =8)
	private String name;
	
	@NotEmpty
	private String birth;
	
	@NotEmpty
	private String contact;
	
	@NotEmpty
	private String gender;
	private boolean isWithdrawal;

	public UserVo() {}
	
	public UserVo(String id, String password) {
		this.id = id;
		this.password = password;
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

	public boolean isWithdrawal() {
		return isWithdrawal;
	}

	public void setWithdrawal(boolean isWithdrawal) {
		this.isWithdrawal = isWithdrawal;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", birth="
				+ birth + ", contact=" + contact + ", gender=" + gender + ", isWithdrawal=" + isWithdrawal + "]";
	}

}
