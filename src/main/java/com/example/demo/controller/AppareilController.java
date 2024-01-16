package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Appareil;
//import com.example.demo.entities.Categorie;
import com.example.demo.service.AppareilService;
import com.example.demo.service.CategorieService;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/Appareil")
public class AppareilController {
	
	@Autowired
	AppareilService appareilservice;
	
	@Autowired
	CategorieService categoriService;
	
	/*@Autowired
	RestTemplate restTemplate;
	
	
	String rating_uri = "http://localhost:8080/api/rating/";
	String user_uri = "http://localhost:3033/user/";*/
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("")
	public  Appareil save(@RequestBody Appareil entity) {
		return appareilservice.save(entity);
	}
	
	@GetMapping("")
	public List<Appareil> findAll() {
		return appareilservice.findAll();
	}

	@GetMapping("id/{id}")
	public Optional<Appareil> findById(@PathVariable Long id) {
		return appareilservice.findById(id);
	}

	@DeleteMapping("id/{id}")
	public void deleteById(@PathVariable Long id) {
		appareilservice.deleteById(id);
	}

	@DeleteMapping("")
	public void deleteAll() {
		appareilservice.deleteAll();
	}
	
	@PutMapping("id/{id}")
	public ResponseEntity<Appareil> update(@PathVariable Long id, @RequestBody Appareil appareil){
		return appareilservice.updateAppareil(id, appareil);
	}
	
	@PostMapping("/switchAllOn")
    public void switchAllOn() {
		appareilservice.switchAllOn();
    }
	
	@PostMapping("/switchAllOff")
    public void switchAllOff() {
		appareilservice.switchAllOff();
    }
	
	
	
	
}
