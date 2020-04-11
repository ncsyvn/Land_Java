package com.nguyencongsy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ProcessImage {
	public static String saveFile(MultipartFile file) {
		String host = "http://localhost:8080/";
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
//				String fileLocation = new File(new String("Uploads/" + fileName));
				String fileLocation = new File("uploads") + "\\" + fileName;
				FileOutputStream fos = new FileOutputStream(fileLocation);
				fos.write(bytes);
				fos.close();
				
				return "/uploads/" + fileName;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
}
