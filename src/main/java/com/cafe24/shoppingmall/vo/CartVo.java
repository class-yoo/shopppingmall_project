package com.cafe24.shoppingmall.vo;

public class CartVo {

	private Long no;
	private int amount;
	private String userId;
	private Long displayedProductNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getDisplayedProductNo() {
		return displayedProductNo;
	}

	public void setDisplayedProductNo(Long displayedProductNo) {
		this.displayedProductNo = displayedProductNo;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", amount=" + amount + ", userId=" + userId + ", displayedProductNo="
				+ displayedProductNo + "]";
	}

}
