package com.nguyencongsy.models.request;

import java.sql.Date;

public class NewCreate{
    public String NewId;
    public String NewCategoryId; 
    public String NewName;
    public String NewSortName;
    public String NewDescription;
    public String NewBody;
    public boolean IsHotNew;
    public String NewTag;
    
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

	public boolean getIsHotNew() {
		return IsHotNew;
	}
	public void setIsHotNew(boolean isHotNew) {
		IsHotNew = isHotNew;
	}
	public String getNewTag() {
		return NewTag;
	}
	public void setNewTag(String newTag) {
		NewTag = newTag;
	}      
}