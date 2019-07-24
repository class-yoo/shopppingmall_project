package com.cafe24.shoppingmall.vo;

import java.util.List;

public class ProductVo {
	private Long no;
	private String code;
	private String name;
	private String material;
	private String description;
	private String detailDescription;
	private int supplyPrice;
	private int consumerPrice;
	private String manufacturer;
	private String supplier;
	private String home;
	private String manufactureDate;
	private String restockCheck;
	private Long purchaseCount;
	private String displayCheck;
	private String saleCheck;
	private Long hits;
	private int preferenceScore;
	private int postPriority;
	private Long categoryNo;

	private List<DisplayedProductVo> displayedProducts;
	private List<OptionVo> options;
	private List<ProductImage> productImages;

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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public int getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public int getConsumerPrice() {
		return consumerPrice;
	}

	public void setConsumerPrice(int consumerPrice) {
		this.consumerPrice = consumerPrice;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getRestockCheck() {
		return restockCheck;
	}

	public void setRestockCheck(String restockCheck) {
		this.restockCheck = restockCheck;
	}

	public Long getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(Long purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public String getDisplayCheck() {
		return displayCheck;
	}

	public void setDisplayCheck(String displayCheck) {
		this.displayCheck = displayCheck;
	}

	public String getSaleCheck() {
		return saleCheck;
	}

	public void setSaleCheck(String saleCheck) {
		this.saleCheck = saleCheck;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public int getPreferenceScore() {
		return preferenceScore;
	}
	
	public void setPreferenceScore(int preferenceScore) {
		this.preferenceScore = preferenceScore;
	}

	public int getPostPriority() {
		return postPriority;
	}

	public void setPostPriority(int postPriority) {
		this.postPriority = postPriority;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public List<DisplayedProductVo> getDisplayedProducts() {
		return displayedProducts;
	}

	public void setDisplayedProducts(List<DisplayedProductVo> displayedProducts) {
		this.displayedProducts = displayedProducts;
	}

	public List<OptionVo> getOptions() {
		return options;
	}

	public void setOptions(List<OptionVo> options) {
		this.options = options;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", code=" + code + ", name=" + name + ", material=" + material + ", description="
				+ description + ", detailDescription=" + detailDescription + ", supplyPrice=" + supplyPrice
				+ ", consumerPrice=" + consumerPrice + ", manufacturer=" + manufacturer + ", supplier=" + supplier
				+ ", home=" + home + ", manufactureDate=" + manufactureDate + ", restockCheck=" + restockCheck
				+ ", purchaseCount=" + purchaseCount + ", displayCheck=" + displayCheck + ", saleCheck=" + saleCheck
				+ ", hits=" + hits + ", preferenceScore=" + preferenceScore + ", postPriority=" + postPriority
				+ ", categoryNo=" + categoryNo + ", displayedProducts=" + displayedProducts + ", options=" + options
				+ ", productImages=" + productImages + ", getNo()=" + getNo() + ", getCode()=" + getCode()
				+ ", getName()=" + getName() + ", getMaterial()=" + getMaterial() + ", getDescription()="
				+ getDescription() + ", getDetailDescription()=" + getDetailDescription() + ", getSupplyPrice()="
				+ getSupplyPrice() + ", getConsumerPrice()=" + getConsumerPrice() + ", getManufacturer()="
				+ getManufacturer() + ", getSupplier()=" + getSupplier() + ", getHome()=" + getHome()
				+ ", getManufactureDate()=" + getManufactureDate() + ", getRestockCheck()=" + getRestockCheck()
				+ ", getPurchaseCount()=" + getPurchaseCount() + ", getDisplayCheck()=" + getDisplayCheck()
				+ ", getSaleCheck()=" + getSaleCheck() + ", getHits()=" + getHits() + ", getPreferenceScore()="
				+ getPreferenceScore() + ", getPostPriority()=" + getPostPriority() + ", getCategoryNo()="
				+ getCategoryNo() + ", getDisplayedProducts()=" + getDisplayedProducts() + ", getOptions()="
				+ getOptions() + ", getProductImages()=" + getProductImages() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
