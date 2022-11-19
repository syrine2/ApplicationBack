package ppe.projet.site.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppe.projet.site.dao.RubriqueRepository;
import ppe.projet.site.entites.Rubrique;

@Service
@Transactional
public class RubriqueServices {

	 @Autowired
	 private RubriqueRepository repo ;
	 
	 public List<Rubrique> listAll(){
		 return repo.findAll();
		 
	 }
	 
	 
}
