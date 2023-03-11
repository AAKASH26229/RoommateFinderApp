package com.springrest.roommateapp.services;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	public void saveImage(String name, MultipartFile file) throws IOException;
	
	 public ResponseEntity<byte[]> getImage(Long id);
}
