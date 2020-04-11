package com.nguyencongsy.models.request;

public class NewCategoryUpdate {
	public String NewCategoryId;
	public String NewCategoryName;
	public int OrderNo;
	public boolean IsActive;
	
	public boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
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
