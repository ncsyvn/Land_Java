package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Product;
import com.nguyencongsy.repositories.IProductRepository;
import com.nguyencongsy.services.IProductService;
import com.nguyencongsy.utils.ProcessImage;

@Service
public class ProductService implements IProductService {
	@Autowired 
	private IProductRepository repository;
	
	@Override
	public List<Product> GetAllProducts() {
		List<Product> result = null;
		try {
			result = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Product> SearchProductsByName (String ProductName){
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if((p.getProductName()).toLowerCase().contains(ProductName.toLowerCase()) == true) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public List<Product> SearchProductsByProductCategory (String ProductCategoryId){
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if((p.getProductCategoryId()).toLowerCase().contains(ProductCategoryId.toLowerCase()) == true) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public List<Product> GetDetailProduct (int ProductId){
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if(p.getProductId() == ProductId) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public List<Product> SearchByAllValue(String ParentProductCategoryId, String ProductCategoryId,
            float ProductPriceStart, float ProductPriceEnd, float ProductAreaStart, 
            float ProductAreaEnd, String ProductAddress){
		
		int checkProductCategoryId = 1;
        int checkPrice = 1;
        int checkArea = 1;
        int checkAddress = 1;

        if (ProductCategoryId == "") checkProductCategoryId = 0;
        if (ProductPriceStart == 0 && ProductPriceEnd == 0) checkPrice = 0;
        if (ProductAreaStart == 0 && ProductAreaEnd == 0) checkArea = 0;
        if (ProductAddress == "") checkAddress = 0;
        
        List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		result = repository.findAll();
		
		
		if (checkProductCategoryId == 0 && checkPrice == 0 && checkArea == 0 && checkAddress == 0){
			for (Product p:result){
					lastResult.add(p);
				}
			}
        else if (checkProductCategoryId == 0 && checkPrice == 0 && checkArea == 0 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductAddress() != null &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
				lastResult.add(p);
			}
		}
        else if (checkProductCategoryId == 0 && checkPrice == 0 && checkArea == 1 && checkAddress == 0){
        	for (Product p:result){
        		if (p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 0 && checkPrice == 0 && checkArea == 1 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductAddress() != null &&
        				p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
        			lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 0 && checkPrice == 1 && checkArea == 0 && checkAddress == 0){
        	for (Product p:result){
        		if (p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 0 && checkPrice == 1 && checkArea == 0 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductAddress() != null &&
        				p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 0 && checkPrice == 1 && checkArea == 1 && checkAddress == 0){
        	for (Product p:result){
        		if (p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd &&
                		p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 0 && checkPrice == 1 && checkArea == 1 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductAddress() != null &&
        				p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd &&
                		p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
				lastResult.add(p);
			}
        }
		
		
		
		
		// Is category is not null
		if (checkProductCategoryId == 1 && checkPrice == 0 && checkArea == 0 && checkAddress == 0){
			for (Product p:result){
				if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true)
					lastResult.add(p);
				}
			}
        else if (checkProductCategoryId == 1 && checkPrice == 0 && checkArea == 0 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductAddress() != null &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
				lastResult.add(p);
			}
		}
        else if (checkProductCategoryId == 1 && checkPrice == 0 && checkArea == 1 && checkAddress == 0){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 1 && checkPrice == 0 && checkArea == 1 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductAddress() != null &&
        				p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
        			lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 1 && checkPrice == 1 && checkArea == 0 && checkAddress == 0){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 1 && checkPrice == 1 && checkArea == 0 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductAddress() != null &&
        				p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 1 && checkPrice == 1 && checkArea == 1 && checkAddress == 0){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd &&
                		p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd)
				lastResult.add(p);
			}
        }

        else if (checkProductCategoryId == 1 && checkPrice == 1 && checkArea == 1 && checkAddress == 1){
        	for (Product p:result){
        		if (p.getProductCategoryId() != null &&
        				p.getProductCategoryId().toLowerCase().contains(ProductCategoryId.toLowerCase())==true &&
        				p.getProductAddress() != null &&
        				p.getProductPrice()>=ProductPriceStart && p.getProductPrice()<=ProductPriceEnd &&
                		p.getProductArea()>=ProductAreaStart && p.getProductArea()<=ProductAreaEnd &&
        				p.getProductAddress().toLowerCase().contains(ProductAddress.toLowerCase())==true)
				lastResult.add(p);
			}
        }
		
		return lastResult;
	}
	
	@Override
	public Page<Product> GetPage(int PageSize, int PageNumber)  {
		int i;
		int len;
		Page<Product> page = new Page<Product>();
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
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
	public void CreateProduct(Product p)  {
		try {
			repository.save(p);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void UpdateProduct(Product p)  {
		try {
			repository.save(p);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void DeleteProduct(int ProductId)  {
		List<Product> result = null;
		ArrayList<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if(p.getProductId() == ProductId) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (lastResult.size() != 0)
		{
			repository.delete(lastResult.get(0));
		} 
	}
	@Override
	public String UploadImages(ArrayList<MultipartFile> images, int ProductId)  {
		try {
			int i;
			MultipartFile image;
			String productImages = "";
			String fileName = "";
			for (i=0; i<images.size(); i++) {
				image = images.get(i);
				fileName = ProcessImage.saveFile(image);
				productImages = productImages + fileName + "*";
			}
			
			List<Product> result = null;
			result = repository.findAll();
			for (Product p:result){
				if(p.getProductId() == ProductId) {
					p.setProductImage(productImages);
					repository.save(p);
					break;
				}	
			}
			return productImages;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}