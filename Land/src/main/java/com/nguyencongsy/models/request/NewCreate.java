package com.nguyencongsy.models.request;

public class NewCreate{
    public int NewCategoryId; 
    public String NewName;
    public String NewSortName;
    public String NewDescription;
    public String NewBody;
    public boolean IsHotNew;
    public String NewTag;
    
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