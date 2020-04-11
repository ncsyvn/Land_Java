package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.New;

public interface  INewService {
	List<New> GetAllNews();
	List<New> SearchNewById(String NewId);
	void CreateNew(New n);
	void UpdateNew(New n);
	void DeleteNew(String NewId);
}
