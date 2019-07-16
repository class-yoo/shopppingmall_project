package com.cafe24.shoppingmall.vo;

public class DisplayedProductVo {

	private Long no;
	private String code;
	private String option;
	private int amount;
	private String stockCheck;
	private int additionalFee;
	private ProductVo productVo;

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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStockCheck() {
		return stockCheck;
	}

	public void setStockCheck(String stockCheck) {
		this.stockCheck = stockCheck;
	}

	public int getAdditionalFee() {
		return additionalFee;
	}

	public void setAdditionalFee(int additionalFee) {
		this.additionalFee = additionalFee;
	}

	public ProductVo getProductVo() {
		return productVo;
	}

	public void setProductVo(ProductVo productVo) {
		this.productVo = productVo;
	}

	@Override
	public String toString() {
		return "DisplayedProductVo [no=" + no + ", code=" + code + ", option=" + option + ", amount=" + amount
				+ ", stockCheck=" + stockCheck + ", additionalFee=" + additionalFee + ", productVo=" + productVo + "]";
	}
	
}
