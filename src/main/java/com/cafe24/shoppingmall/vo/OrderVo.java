package com.cafe24.shoppingmall.vo;

import java.util.List;

public class OrderVo {

	private Long no;
	private String receiver;
	private String title;
	private String description;
	private String destination;
	private String detailAddress;
	private String postalCode;
	private String requirement;
	private String phoneNumber;
	private String contact;
	private String email;
	private String password;
	private String orderStatus;
	private String orderDate;
	private String refundBank;
	private String refundAccount;
	private int totalPrice;
	private String deliverStatus;
	private String deliverNumber;
	private String trackingNumber;
	private String completeDeliverDate;
	private String userId;
	
	private List<OrderProductVo> orderProducts;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRefundBank() {
		return refundBank;
	}

	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliverStatus() {
		return deliverStatus;
	}

	public void setDeliverStatus(String deliverStatus) {
		this.deliverStatus = deliverStatus;
	}

	public String getDeliverNumber() {
		return deliverNumber;
	}

	public void setDeliverNumber(String deliverNumber) {
		this.deliverNumber = deliverNumber;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCompleteDeliverDate() {
		return completeDeliverDate;
	}

	public void setCompleteDeliverDate(String completeDeliverDate) {
		this.completeDeliverDate = completeDeliverDate;
	}

	public List<OrderProductVo> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProductVo> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", receiver=" + receiver + ", title=" + title + ", description=" + description
				+ ", destination=" + destination + ", detailAddress=" + detailAddress + ", postalCode=" + postalCode
				+ ", requirement=" + requirement + ", phoneNumber=" + phoneNumber + ", contact=" + contact + ", email="
				+ email + ", password=" + password + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", refundBank=" + refundBank + ", refundAccount=" + refundAccount + ", totalPrice=" + totalPrice
				+ ", deliverStatus=" + deliverStatus + ", deliverNumber=" + deliverNumber + ", trackingNumber="
				+ trackingNumber + ", completeDeliverDate=" + completeDeliverDate + ", userId=" + userId
				+ ", orderProducts=" + orderProducts + "]";
	}

	
}
