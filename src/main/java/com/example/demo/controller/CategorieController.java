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

import com.example.demo.entities.Categorie;
import com.example.demo.service.CategorieService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/Categorie")
public class CategorieController {
	
	@Autowired
	CategorieService categorieService;

	@PostMapping("")
	public <S extends Categorie> S save(@RequestBody S entity) {
		return categorieService.save(entity);
	}

	@GetMapping("")
	public List<Categorie> findAll() {
		return categorieService.findAll();
	}

	@GetMapping("id/{id}")
	public Optional<Categorie> findById(@PathVariable Long id) {
		return categorieService.findById(id);
	}

	@DeleteMapping("id/{id}")
	public void deleteById(@PathVariable Long id) {
		categorieService.deleteById(id);
	}
	
	@PutMapping("id/{id}")
	public ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody Categorie categorie){
		return categorieService.updateCategorie(id, categorie);
	}
	
	

}
