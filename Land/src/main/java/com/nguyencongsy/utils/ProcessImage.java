package com.nguyencongsy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class ProcessImage {
	public static String saveFile(MultipartFile file) {
		String host = "http://localhost:8080/";
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				Random rand = new Random();
				int rand_int = rand.nextInt(1000000); 
				bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
				fileName = fileName.split("\\.")[0];
				String fileLocation = new File("uploads") + "\\" + fileName + "_" + String.valueOf(rand_int) + ".jpg";
				FileOutputStream fos = new FileOutputStream(fileLocation);
				fos.write(bytes);
				fos.close();
				
				return "/uploads/" + fileName + "_" + String.valueOf(rand_int) + ".jpg";
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

