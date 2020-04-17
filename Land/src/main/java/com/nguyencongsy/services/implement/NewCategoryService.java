package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.NewCategory;
import com.nguyencongsy.models.Page;
import com.nguyencongsy.repositories.INewCategoryRepository;
import com.nguyencongsy.services.INewCategoryService;

@Service
public class NewCategoryService implements INewCategoryService {
	@Autowired 
	private INewCategoryRepository repository;
	
	@Override
	public List<NewCategory> GetAllNewCategories() {
		List<NewCategory> result = null;
		try {
			result = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<NewCategory> SearchNewCategoryById(String newCategoryId){
		List<NewCategory> result = null;
		List<NewCategory> lastResult = new ArrayList<NewCategory>();
		try {
			result = repository.findAll();
			for (NewCategory nc:result){
				if(nc.getNewCategoryId().toLowerCase().contains(newCategoryId.toLowerCase()) == true) {
					lastResult.add(nc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	@Override
	public Page<NewCategory> GetPage(int PageSize, int PageNumber)  {
		int i;
		int len;
		Page<NewCategory> page = new Page<NewCategory>();
		List<NewCategory> result = null;
		List<NewCategory> lastResult = new ArrayList<NewCategory>();
		try {
			result = repository.findAll();
			len = result.size();
			if (PageNumber*PageSize < len) {
				for (i=PageNumber*PageSize; i<PageNumber*PageSize+PageSize; i++)
				{
					if (i<len) {
						lastResult.add(result.get(i));
					}
				}
			page.setPageNumber(PageNumber);
			page.setPageSize(PageSize);
			page.setTotalNumberOfPages(123);
			page.setTotalNumberOfRecords(len);
			page.setResults(lastResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	@Override
	public void CreateNewCategory(NewCategory nc)  {
		try {
			repository.save(nc);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void UpdateNewCategory(NewCategory nc)  {
		try {
			repository.save(nc);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void DeleteNewCategory(String NewCategoryId)  {
		try {
			repository.deleteById(NewCategoryId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}