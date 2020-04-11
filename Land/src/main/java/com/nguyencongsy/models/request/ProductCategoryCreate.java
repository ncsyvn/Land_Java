package com.nguyencongsy.models.request;

import org.springframework.web.multipart.MultipartFile;

public class ProductCategoryCreate {
	private String ProductCategoryId;
    private String ParentProductCategoryId;
    private String ProductCategoryTitle;
    private String ProductCategoryName;
    private int OrderNo;
    private String CreateBy;
    private String ProductCategoryDescription;
    private String ProductCategoryKeyword;
    private MultipartFile ProductCategoryImage;
	public String getProductCategoryId() {
		return ProductCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		ProductCategoryId = productCategoryId;
	}
	public String getParentProductCategoryId() {
		return ParentProductCategoryId;
	}
	public void setParentProductCategoryId(String parentProductCategoryId) {
		ParentProductCategoryId = parentProductCategoryId;
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
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
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
	public MultipartFile getProductCategoryImage() {
		return ProductCategoryImage;
	}
	public void setProductCategoryImage(MultipartFile productCategoryImage) {
		ProductCategoryImage = productCategoryImage;
	}
    
    
    

}
