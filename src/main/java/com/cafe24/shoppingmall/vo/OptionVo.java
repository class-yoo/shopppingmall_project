package com.cafe24.shoppingmall.vo;

public class OptionVo {

	private Long no;
	private String code;
	private String optionKey;
	private String optionValues;
	private Long productNo;
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOptionKey() {
		return optionKey;
	}

	public void setOptionKey(String optionKey) {
		this.optionKey = optionKey;
	}

	public String getOptionValues() {
		return optionValues;
	}

	public void setOptionValues(String optionValues) {
		this.optionValues = optionValues;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "OptionVo [no=" + no + ", code=" + code + ", optionKey=" + optionKey + ", optionValues=" + optionValues
				+ ", productNo=" + productNo + "]";
	}

}
