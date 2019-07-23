package com.cafe24.shoppingmall.vo;

public class DisplayedProductVo {

	private Long no;
	private String code;
	private String name;
	private String option;
	private String mainImagePath;
	private int amount;
	private String stockCheck;
	private int additionalFee;
	private int price;
	private Long ProductNo;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getMainImagePath() {
		return mainImagePath;
	}

	public void setMainImagePath(String mainImagePath) {
		this.mainImagePath = mainImagePath;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getProductNo() {
		return ProductNo;
	}

	public void setProductNo(Long productNo) {
		ProductNo = productNo;
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
