package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.New;
import com.nguyencongsy.repositories.INewRepository;
import com.nguyencongsy.services.INewService;

@Service
public class NewService implements INewService {
	@Autowired 
	private INewRepository repository;
	
	@Override
	public List<New> GetAllNews() {
		List<New> result = null;
		try {
			result = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<New> SearchNewById(String NewId){
		List<New> result = null;
		List<New> lastResult = new ArrayList<New>();
		try {
			result = repository.findAll();
			for (New n:result){
				if(n.getNewId().toLowerCase().contains(NewId.toLowerCase()) == true) {
					lastResult.add(n);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	@Override
	public void CreateNew(New n)  {
		try {
			repository.save(n);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void UpdateNew(New n)  {
		try {
			repository.save(n);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void DeleteNew(String NewId)  {
		try {
			repository.deleteById(NewId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}