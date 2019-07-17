package com.cafe24.shoppingmall.vo;

public class ProductImage {
	
	private Long no;
	private String imagePath;
	private String isMainImage;
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
	public String getIsMainImage() {
		return isMainImage;
	}
	public void setIsMainImage(String isMainImage) {
		this.isMainImage = isMainImage;
	}
	@Override
	public String toString() {
		return "ProductImage [no=" + no + ", imagePath=" + imagePath + ", isMainImage=" + isMainImage + "]";
	}
	
}
