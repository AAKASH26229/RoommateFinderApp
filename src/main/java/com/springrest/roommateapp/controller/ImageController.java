package com.springrest.roommateapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.springrest.roommateapp.services.ImageService;

@Controller
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping("/")
	public void uploadImage(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {
        imageService.saveImage(name, file);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        return imageService.getImage(id);
    }
	
}
