package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Appareil;

@Repository
public interface AppareilRepository extends JpaRepository<Appareil, Long>{
	List<Appareil> findByOrderById();
	
}
