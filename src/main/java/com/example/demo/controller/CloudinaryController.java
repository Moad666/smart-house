package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Appareil;
import com.example.demo.service.AppareilService;
import com.example.demo.service.CloudinaryService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/cloudinary")
@CrossOrigin(origins = "http://localhost:4200/")
public class CloudinaryController {
	@Autowired
    CloudinaryService cloudinaryService;
	
	 @Autowired
	    AppareilService appareilService;

	 	
	 @PostMapping("/upload")
	    @ResponseBody
	    public ResponseEntity<String> upload(@RequestParam MultipartFile multipartFile) throws IOException {
	        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
	        if (bi == null) {
	            return new ResponseEntity<>("Image non valide!", HttpStatus.BAD_REQUEST);
	        }
	        Map result = cloudinaryService.upload(multipartFile);
	        Appareil image = new Appareil();
	        image.setImageUrl((String) result.get("url"));
	        appareilService.save(image);
	        return new ResponseEntity<>("image ajoutée avec succès ! ", HttpStatus.OK);
	    }
	 
	 
	
}
