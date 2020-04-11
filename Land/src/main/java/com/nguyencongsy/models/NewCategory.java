package com.nguyencongsy.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NewCategories")
public class NewCategory implements Serializable{
	@Id
	@Column(name = "NewCategoryId")
	public String NewCategoryId; 
	
	@Column(name = "NewCategoryName")
    public String NewCategoryName;
	
	@Column(name = "OrderNo")
    public int OrderNo;
	
	@Column(name = "IsActive")
    public boolean IsActive;
	
	@Column(name = "CreateDtime")
    public Date CreateDtime;
	
	@Column(name = "UpdateDtime")
    public Date UpdateDtime;
	
	@Column(name = "Id")
    public String Id;
    
    /* Get and Set */
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
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public Date getCreateDtime() {
		return CreateDtime;
	}
	public void setCreateDtime(Date createDtime) {
		CreateDtime = createDtime;
	}
	public Date getUpdateDtime() {
		return UpdateDtime;
	}
	public void setUpdateDtime(Date updateDtime) {
		UpdateDtime = updateDtime;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public NewCategory() {}
	public NewCategory(String NewCategoryId, String NewCategoryName, int OrderNo, boolean IsActive) {
		this.NewCategoryId = NewCategoryId;
		this.NewCategoryName = NewCategoryName;
		this.OrderNo = OrderNo;
		this.IsActive = IsActive;
	}
    
    
}