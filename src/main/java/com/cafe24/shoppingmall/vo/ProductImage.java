package com.cafe24.shoppingmall.vo;

public class ProductImage {

	private Long no;
	private String imagePath;
	private String mainImageCheck;
	private Long productNo;
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getMainImageCheck() {
		return mainImageCheck;
	}

	public void setMainImageCheck(String mainImageCheck) {
		this.mainImageCheck = mainImageCheck;
	}
	
	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "ProductImage [no=" + no + ", imagePath=" + imagePath + ", mainImageCheck=" + mainImageCheck
				+ ", productNo=" + productNo + "]";
	}
	
}
