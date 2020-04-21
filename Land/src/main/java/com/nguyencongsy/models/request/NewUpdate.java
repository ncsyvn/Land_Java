package com.nguyencongsy.models.request;

import java.sql.Date;

public class NewUpdate{
	 public int NewId;
     public int NewCategoryId;    
     public String NewName;
     public String NewSortName;
     public String NewImage;
     public String NewDescription;
     public String NewBody;
     public int Count;
     public boolean Enable;
     public boolean IsHotNew;
     public Date CreateDtime;
     public String NewTag;
	public int getNewId() {
		return NewId;
	}
	public void setNewId(int newId) {
		NewId = newId;
	}
	public int getNewCategoryId() {
		return NewCategoryId;
	}
	public void setNewCategoryId(int newCategoryId) {
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
	public boolean getIsHotNew() {
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
}