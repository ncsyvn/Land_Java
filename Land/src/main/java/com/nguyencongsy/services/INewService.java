package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.New;
import com.nguyencongsy.models.Page;

public interface  INewService {
	List<New> GetAllNews();
	List<New> SearchNewById(int NewId);
	Page<New> GetPage(int PageSize, int PageNumber);
	void CreateNew(New n);
	void UpdateNew(New n);
	void DeleteNew(int NewId);
}
