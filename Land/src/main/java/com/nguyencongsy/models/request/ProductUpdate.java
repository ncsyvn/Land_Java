package com.nguyencongsy.models.request;

import org.springframework.web.multipart.MultipartFile;

public class ProductUpdate{
    public String ProductId;   
    public String ProductCategoryId;	
    public String ProductName;
    public String ProductSummary;
    public double ProductPrice;
    public double ProductArea;
    public int ProductBedrooms;
    public int ProductBathrooms;
    public String ProductAddress;
    public int OrderNo;
    public boolean IsHotProduct;
    public double ProductPriceMeter;
    public int ProductFloors;
    private MultipartFile ProductThumbnail;

	
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
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
	
	public MultipartFile getProductThumbnail() {
		return ProductThumbnail;
	}
	public void setProductThumbnail(MultipartFile productThumbnail) {
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
	
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	public boolean getIsHotProduct() {
		return IsHotProduct;
	}
	public void setIsHotProduct(boolean isHotProduct) {
		IsHotProduct = isHotProduct;
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

    /* Get and set */     
}
