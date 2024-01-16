package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategorieRepository;
import com.example.demo.entities.Categorie;

@Service
public class CategorieService {
	
	@Autowired
	CategorieRepository categorieRepository;

	public <S extends Categorie> S save(S entity) {
		return categorieRepository.save(entity);
	}

	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	public Optional<Categorie> findById(Long id) {
		return categorieRepository.findById(id);
	}

	public void deleteById(Long id) {
		categorieRepository.deleteById(id);
	}
	
	public ResponseEntity<Categorie> updateCategorie(Long id, Categorie categorie) {
	    Optional<Categorie> optionalCategorie = categorieRepository.findById(id);

	    if (optionalCategorie.isPresent()) {
	        Categorie existingCategorie = optionalCategorie.get();
	        existingCategorie.setLabelle(categorie.getLabelle());

	        Categorie updatedCategorie = categorieRepository.save(existingCategorie);
	        return ResponseEntity.ok(updatedCategorie);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	
}
