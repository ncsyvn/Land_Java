package com.nguyencongsy.models.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadImagesModel {
	private ArrayList<MultipartFile> images;
	public String ProductId;
	
	public ArrayList<MultipartFile> getImages() {
		return images;
	}
	public void setImages(ArrayList<MultipartFile> images) {
		this.images = images;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	
	
}
