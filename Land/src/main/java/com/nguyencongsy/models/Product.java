package com.nguyencongsy.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product implements Serializable{
	@Id
	@Column(name = "ProductId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ProductId;   
		
	@Column(name = "ProductCategoryId")
    public String ProductCategoryId;	

	@Column(name = "ProductName")
    public String ProductName;
	
	@Column(name = "ProductSummary")
    public String ProductSummary;
	
	@Column(name = "ProductImage")
    public String ProductImage;
	
	@Column(name = "ProductThumbnail")
    public String ProductThumbnail;
	
	@Column(name = "ProductPrice")
    public double ProductPrice;
	
	@Column(name = "ProductArea")
    public double ProductArea;
	
	@Column(name = "ProductBedrooms")
    public int ProductBedrooms;
	
	@Column(name = "ProductBathrooms")
    public int ProductBathrooms;
	
	@Column(name = "ProductAddress")
    public String ProductAddress;
	
	@Column(name = "UpdateBy")
	public String UpdateBy;
	
	@Column(name = "OrderNo")
    public int OrderNo;
	
	@Column(name = "IsActive")
    public boolean IsActive;
	
	@Column(name = "IsHotProduct")
    public boolean IsHotProduct;
	
	@Column(name = "ProductReviewHtml")
    public String ProductReviewHtml;
	
	@Column(name = "ProductPriceMeter")
    public double ProductPriceMeter;
	
	@Column(name = "ProductFloors")
    public int ProductFloors;
	
	@Column(name = "ProductTag")
    public String ProductTag;
	
	@Column(name = "CreateDtime")
    public Date CreateDtime;
	
	@Column(name = "UpdateDtime")
    public Date UpdateDtime;
	
	
	public Product() {}
	
	public Product(String ProductCategoryId, String ProductName, String ProductSummary,
			double ProductPrice, double ProductArea, int ProductBedrooms, int ProductBathrooms,
			String ProductAddress, int OrderNo, boolean IsHotProduct, double ProductPriceMeter, int ProductFloors) {
			
		this.ProductCategoryId = ProductCategoryId;
		this.ProductName = ProductName;
		this.ProductSummary = ProductSummary;
		this.ProductPrice = ProductPrice;
		this.ProductArea = ProductArea;
		this.ProductBedrooms = ProductBedrooms;
		this.ProductBathrooms = ProductBathrooms;
		this.ProductAddress = ProductAddress;
		this.OrderNo = OrderNo;
		this.IsHotProduct = IsHotProduct;
		this.ProductPriceMeter = ProductPriceMeter;
		this.ProductFloors = ProductFloors;
	}
	
	public Product(int ProductId, String ProductCategoryId, String ProductName, String ProductSummary,
			double ProductPrice, double ProductArea, int ProductBedrooms, int ProductBathrooms,
			String ProductAddress, int OrderNo, boolean IsHotProduct, double ProductPriceMeter, int ProductFloors) {
		
		this.ProductId = ProductId;
		this.ProductCategoryId = ProductCategoryId;
		this.ProductName = ProductName;
		this.ProductSummary = ProductSummary;
		this.ProductPrice = ProductPrice;
		this.ProductArea = ProductArea;
		this.ProductBedrooms = ProductBedrooms;
		this.ProductBathrooms = ProductBathrooms;
		this.ProductAddress = ProductAddress;
		this.OrderNo = OrderNo;
		this.IsHotProduct = IsHotProduct;
		this.ProductPriceMeter = ProductPriceMeter;
		this.ProductFloors = ProductFloors;
	}
	
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductCategoryId() {
		return ProductCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		ProductCategoryId = productCategoryId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductSummary() {
		return ProductSummary;
	}
	public void setProductSummary(String productSummary) {
		ProductSummary = productSummary;
	}
	public String getProductImage() {
		return ProductImage;
	}
	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}
	public String getProductThumbnail() {
		return ProductThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		ProductThumbnail = productThumbnail;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public double getProductArea() {
		return ProductArea;
	}
	public void setProductArea(double productArea) {
		ProductArea = productArea;
	}
	public int getProductBedrooms() {
		return ProductBedrooms;
	}
	public void setProductBedrooms(int productBedrooms) {
		ProductBedrooms = productBedrooms;
	}
	public int getProductBathrooms() {
		return ProductBathrooms;
	}
	public void setProductBathrooms(int productBathrooms) {
		ProductBathrooms = productBathrooms;
	}
	public String getProductAddress() {
		return ProductAddress;
	}
	public void setProductAddress(String productAddress) {
		ProductAddress = productAddress;
	}
	public String getUpdateBy() {
		return UpdateBy;
	}
	public void setUpdateBy(String updateBy) {
		UpdateBy = updateBy;
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
	public boolean getIsHotProduct() {
		return IsHotProduct;
	}
	public void setIsHotProduct(boolean isHotProduct) {
		IsHotProduct = isHotProduct;
	}
	public String getProductReviewHtml() {
		return ProductReviewHtml;
	}
	public void setProductReviewHtml(String productReviewHtml) {
		ProductReviewHtml = productReviewHtml;
	}
	public double getProductPriceMeter() {
		return ProductPriceMeter;
	}
	public void setProductPriceMeter(double productPriceMeter) {
		ProductPriceMeter = productPriceMeter;
	}
	public int getProductFloors() {
		return ProductFloors;
	}
	public void setProductFloors(int productFloors) {
		ProductFloors = productFloors;
	}
	public String getProductTag() {
		return ProductTag;
	}
	public void setProductTag(String productTag) {
		ProductTag = productTag;
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

    /* Get and set */
       
	        
	     
}
