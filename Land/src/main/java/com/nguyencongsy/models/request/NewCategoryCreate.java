package com.nguyencongsy.models.request;

public class NewCategoryCreate {
	public String NewCategoryId;
	public String NewCategoryName;
	public int OrderNo;
	
	public String getNewCategoryId() {
		return NewCategoryId;
	}
	public void setNewCategoryId(String newCategoryId) {
		NewCategoryId = newCategoryId;
	}
	public String getNewCategoryName() {
		return NewCategoryName;
	}
	public void setNewCategoryName(String newCategoryName) {
		NewCategoryName = newCategoryName;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	
}
