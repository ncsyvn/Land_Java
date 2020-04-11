package com.nguyencongsy.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.User;
import com.nguyencongsy.repositories.IUserRepository;
import com.nguyencongsy.services.IUserService;

// import bam ctrl shift O
// tu dong import

@Service
public class UserService implements IUserService {
	@Autowired 
	private IUserRepository repository;
	@Override
	public List<User> findAll() {
		List<User> result = null;
		try {
			result = repository.findAll();
			//
			// tim kiem 1 thang theo id
//			repository.findById(id)
//			them 1 thang
//			repository.save(entity)
//			entity chinh la 1 new Lop
			// sua thong tin 1thang
//			repository.save(entity)
			//y het them, trong enity chua id can sua la ok
			// xoa 1 thang
//			repository.delete(entity);
//			truyen vao 1 entity can xoa
//			phan trang
//			repository.findAll(pageable)//
//			pageable la 1 doi tuong page: pageNumber, pageSize
			
//			day la hau het ham ma interface JPARepository cung cap cho may
			// see more
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}