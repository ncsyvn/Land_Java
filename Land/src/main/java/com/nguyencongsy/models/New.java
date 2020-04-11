package com.nguyencongsy.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "News")
public class New implements Serializable{
	@Id
	@Column(name = "NewId")
	public String NewId;
	
	@Column(name = "NewCategoryId")
    public String NewCategoryId;
	
	@Column(name = "NewName")
    public String NewName;
	
	@Column(name = "NewSortName")
    public String NewSortName;
	
	@Column(name = "NewImage")
    public String NewImage;
	
	@Column(name = "NewDescription")
    public String NewDescription;
	
	@Column(name = "NewBody")
    public String NewBody;
	
	@Column(name = "Count")
    public int Count;
	
	@Column(name = "Enable")
    public boolean Enable;
	
	@Column(name = "IsHotNew")
    public boolean IsHotNew;
	
	@Column(name = "CreateDtime")
    public Date CreateDtime;
	
	@Column(name = "NewTag")
    public String NewTag;
	
	@Column(name = "Id")
    public String Id;
    
    /*Get and Set */
	public String getNewId() {
		return NewId;
	}
	public void setNewId(String newId) {
		NewId = newId;
	}
	public String getNewCategoryId() {
		return NewCategoryId;
	}
	public void setNewCategoryId(String newCategoryId) {
		NewCategoryId = newCategoryId;
	}
	public String getNewName() {
		return NewName;
	}
	public void setNewName(String newName) {
		NewName = newName;
	}
	public String getNewSortName() {
		return NewSortName;
	}
	public void setNewSortName(String newSortName) {
		NewSortName = newSortName;
	}
	public String getNewImage() {
		return NewImage;
	}
	public void setNewImage(String newImage) {
		NewImage = newImage;
	}
	public String getNewDescription() {
		return NewDescription;
	}
	public void setNewDescription(String newDescription) {
		NewDescription = newDescription;
	}
	public String getNewBody() {
		return NewBody;
	}
	public void setNewBody(String newBody) {
		NewBody = newBody;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public boolean isEnable() {
		return Enable;
	}
	public void setEnable(boolean enable) {
		Enable = enable;
	}
	public boolean isIsHotNew() {
		return IsHotNew;
	}
	public void setIsHotNew(boolean isHotNew) {
		IsHotNew = isHotNew;
	}
	public Date getCreateDtime() {
		return CreateDtime;
	}
	public void setCreateDtime(Date createDtime) {
		CreateDtime = createDtime;
	}
	public String getNewTag() {
		return NewTag;
	}
	public void setNewTag(String newTag) {
		NewTag = newTag;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public New() {}
	
	public New(String NewId, String NewName, String NewSortName, 
				String NewDescription, String NewCategoryId, String NewTag,
				String NewBody, boolean IsHotNew){
		this.NewId = NewId;
		this.NewName = NewName;
		this.NewSortName = NewSortName;
		this.NewDescription = NewDescription;
		this.NewCategoryId = NewCategoryId;
		this.NewTag = NewTag;
		this.NewBody = NewBody;
		this.IsHotNew = IsHotNew;
		
	}
    
    

}
