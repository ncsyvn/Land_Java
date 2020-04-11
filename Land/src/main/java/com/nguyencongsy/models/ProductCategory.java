package com.nguyencongsy.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductCategories")
public class ProductCategory implements Serializable{
	
	@Id
	@Column(name = "ProductCategoryId")
	public String ProductCategoryId;
	
	@Column(name = "ProductCategoryTitle")
    public String ProductCategoryTitle;
	
	@Column(name = "ProductCategoryName")
    public String ProductCategoryName;
	
	@Column(name = "OrderNo")
    public int OrderNo;
	
	
	@Column(name = "CreateDtime")
    public Date CreateDtime;
	
	@Column(name = "UpdateDtime")
    public Date UpdateDtime;
	
	@Column(name = "CreateBy")
    public String CreateBy;
	
	@Column(name = "ParentProductCategoryId")
    public String ParentProductCategoryId;
	
	@Column(name = "ProductCategoryDescription")
    public String ProductCategoryDescription;
	
	@Column(name = "ProductCategoryKeyword")
    public String ProductCategoryKeyword;
	
	@Column(name = "ProductCategoryImage")
    public String ProductCategoryImage;
    
    /* Get and set */
	public String getProductCategoryId() {
		return ProductCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		ProductCategoryId = productCategoryId;
	}
	public String getProductCategoryTitle() {
		return ProductCategoryTitle;
	}
	public void setProductCategoryTitle(String productCategoryTitle) {
		ProductCategoryTitle = productCategoryTitle;
	}
	public String getProductCategoryName() {
		return ProductCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		ProductCategoryName = productCategoryName;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
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
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public String getParentProductCategoryId() {
		return ParentProductCategoryId;
	}
	public void setParentProductCategoryId(String parentProductCategoryId) {
		ParentProductCategoryId = parentProductCategoryId;
	}
	public String getProductCategoryDescription() {
		return ProductCategoryDescription;
	}
	public void setProductCategoryDescription(String productCategoryDescription) {
		ProductCategoryDescription = productCategoryDescription;
	}
	public String getProductCategoryKeyword() {
		return ProductCategoryKeyword;
	}
	public void setProductCategoryKeyword(String productCategoryKeyword) {
		ProductCategoryKeyword = productCategoryKeyword;
	}
	public String getProductCategoryImage() {
		return ProductCategoryImage;
	}
	public void setProductCategoryImage(String productCategoryImage) {
		ProductCategoryImage = productCategoryImage;
	}
	public ProductCategory() {}
	
	public ProductCategory(String ProductCategoryId, String ParentProductCategoryId, 
				String ProductCategoryTitle, String ProductCategoryName, int OrderNo, String CreateBy, 
				String ProductCategoryDescription, String ProductCategoryKeyword){
		this.ProductCategoryId = ProductCategoryId;
		this.ParentProductCategoryId = ParentProductCategoryId;
		this.ProductCategoryTitle = ProductCategoryTitle;
		this.ProductCategoryName = ProductCategoryName;
		this.OrderNo = OrderNo;
		this.CreateBy = CreateBy;
		this.ProductCategoryDescription = ProductCategoryDescription;
		this.ProductCategoryKeyword = ProductCategoryKeyword;
	}
    
    
}