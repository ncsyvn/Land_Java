package com.nguyencongsy.models.request;

public class NewCategoryUpdate {
	public int NewCategoryId;
	public String NewCategoryName;
	public int OrderNo;
	public boolean IsActive;
	
	public boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public int getNewCategoryId() {
		return NewCategoryId;
	}
	public void setNewCategoryId(int newCategoryId) {
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
