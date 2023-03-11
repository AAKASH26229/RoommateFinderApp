package com.springrest.roommateapp.services;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.roommateapp.dao.ImageDao;
import com.springrest.roommateapp.entities.Image;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public void saveImage(String name, MultipartFile file) throws IOException {
        Image entity = new Image();
        entity.setName(name);
        entity.setData(file.getBytes());
        imageDao.save(entity);
	}

	
	@Override
	public ResponseEntity<byte[]> getImage(Long id) {
		Image entity = imageDao.findById(id).orElse(null);
        if (entity != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(entity.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		
	}

}
