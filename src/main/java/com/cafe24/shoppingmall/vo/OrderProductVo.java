package com.cafe24.shoppingmall.vo;

public class OrderProductVo {

	private Long orderNo;
	private Long displayedProductNo;
	private int amount;
	private int price;
	
	
	private DisplayedProductVo displayedProductVo;
	
	public Long getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	
	public Long getDisplayedProductNo() {
		return displayedProductNo;
	}

	public void setDisplayedProductNo(Long displayedProductNo) {
		this.displayedProductNo = displayedProductNo;
	}

	public DisplayedProductVo getDisplayedProductVo() {
		return displayedProductVo;
	}

	public void setDisplayedProductVo(DisplayedProductVo displayedProductVo) {
		this.displayedProductVo = displayedProductVo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderProductVo [orderNo=" + orderNo + ", displayedProductNo=" + displayedProductNo + ", amount="
				+ amount + ", price=" + price + ", displayedProductVo=" + displayedProductVo + "]";
	}
	
	

}
