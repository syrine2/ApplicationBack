package ppe.projet.site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ppe.projet.site.dao.BlocRepository;
import ppe.projet.site.entites.Bloc;
import ppe.projet.site.entites.Rubrique;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bloc")
public class BlocController {
	
	@Autowired
	BlocRepository blocRepository;
	
	@GetMapping("/{version}/blocs")
	public ResponseEntity<List<Bloc>> findRubriqueByVersion (@PathVariable Long version) {
		List <Bloc> rub = (blocRepository.findBlocByVersion(version));

		return ResponseEntity.ok(rub);
	}

}
