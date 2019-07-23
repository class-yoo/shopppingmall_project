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
	private String restockCheck;
	private Long purchaseCount;
	private String displayCheck;
	private String saleCheck;
	private Long hits;
	private int preferenceScore;
	private int postPriority;
	private Long categoryNo;
	
	private List<OptionVo> optionVo;
	private ProductImage productImage;

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

	public List<OptionVo> getOptionVo() {
		return optionVo;
	}
	
	public void setOptionVo(List<OptionVo> optionVo) {
		this.optionVo = optionVo;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", code=" + code + ", name=" + name + ", material=" + material + ", description="
				+ description + ", detailDescription=" + detailDescription + ", supplyPrice=" + supplyPrice
				+ ", consumerPrice=" + consumerPrice + ", manufacturer=" + manufacturer + ", supplier=" + supplier
				+ ", home=" + home + ", restockCheck=" + restockCheck + ", purchaseCount=" + purchaseCount
				+ ", displayCheck=" + displayCheck + ", saleCheck=" + saleCheck + ", hits=" + hits
				+ ", preferenceScore=" + preferenceScore + ", postPriority=" + postPriority + ", categoryNo="
				+ categoryNo + ", productImage=" + productImage + "]";
	}

}
