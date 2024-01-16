package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppareilRepository;
import com.example.demo.dao.CategorieRepository;
import com.example.demo.entities.Appareil;
import com.example.demo.entities.Categorie;

@Service
public class AppareilService{
	@Autowired
	AppareilRepository apprareilRepository;
	
	@Autowired
	CategorieRepository categorieRepository;

	public  Appareil save(Appareil entity) {
		/*Appareil a = apprareilRepository.findById(entity.getId()).get();
		a.setCategorie(entity.getCategorie());
		a.setDescription(entity.getDescription());
		a.setLabelle(entity.getLabelle());
		a.setState(entity.getState());*/
		
		
		return apprareilRepository.save(entity);
	}

	public List<Appareil> findAll() {
		return apprareilRepository.findAll();
	}

	public Optional<Appareil> findById(Long id) {
		return apprareilRepository.findById(id);
	}

	public void deleteById(Long id) {
		apprareilRepository.deleteById(id);
	}

	public void deleteAll() {
		apprareilRepository.deleteAll();
	}
	
	public ResponseEntity<Appareil> updateAppareil(Long id, Appareil appareil) {
	    Optional<Appareil> optionalAppareil = apprareilRepository.findById(id);

	    if (optionalAppareil.isPresent()) {
	        Appareil existingAppareil = optionalAppareil.get();
	        existingAppareil.setLabelle(appareil.getLabelle());
	        existingAppareil.setDescription(appareil.getDescription());
	        existingAppareil.setState(appareil.getState());
	        existingAppareil.setCategorie(appareil.getCategorie());

	        Appareil updatedAppareil = apprareilRepository.save(existingAppareil);
	        return ResponseEntity.ok(updatedAppareil);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	public void switchAllOn() {
        List<Appareil> appareils = apprareilRepository.findAll();
        appareils.forEach(appareil -> appareil.setState(true));
        apprareilRepository.saveAll(appareils);
    }
	
	public void switchAllOff() {
		List<Appareil> appareils = apprareilRepository.findAll();
        appareils.forEach(appareil -> appareil.setState(false));
        apprareilRepository.saveAll(appareils);
	}

	
	
}
