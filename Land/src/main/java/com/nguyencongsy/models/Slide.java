package com.nguyencongsy.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Slides")
public class Slide implements Serializable{
	@Id
	@Column(name = "SlideId")
	public int SlideId;
	
	@Column(name = "SlideImage")
    public String SlideImage;
    
	@Column(name = "IsActive")
	public boolean IsActive;
	
	@Column(name = "OrderNo")
    public int OrderNo;  
	
	@Column(name = "UpdateBy")
    public String UpdateBy;
	
	@Column(name = "UpdateDtime")
    public Date UpdateDtime;
	
	@Column(name = "URLSlide")
    public String URLSlide;
	
	@Column(name = "CreateDTime")
    public Date CreateDTime;
	
	@Column(name = "Id")
    public String Id;
    
    /* Get and Set*/
	public int getSlideId() {
		return SlideId;
	}
	public void setSlideId(int slideId) {
		SlideId = slideId;
	}
	public String getSlideImage() {
		return SlideImage;
	}
	public void setSlideImage(String slideImage) {
		SlideImage = slideImage;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	public String getUpdateBy() {
		return UpdateBy;
	}
	public void setUpdateBy(String updateBy) {
		UpdateBy = updateBy;
	}
	public Date getUpdateDtime() {
		return UpdateDtime;
	}
	public void setUpdateDtime(Date updateDtime) {
		UpdateDtime = updateDtime;
	}
	public String getURLSlide() {
		return URLSlide;
	}
	public void setURLSlide(String uRLSlide) {
		URLSlide = uRLSlide;
	}
	public Date getCreateDTime() {
		return CreateDTime;
	}
	public void setCreateDTime(Date createDTime) {
		CreateDTime = createDTime;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
    
    
}