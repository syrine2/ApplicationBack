package ppe.projet.site.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ppe.projet.site.dao.RubriqueRepository;
import ppe.projet.site.entites.Rubrique;
import ppe.projet.site.helper.RubriqueExeclExporter;
import ppe.projet.site.service.RubriqueServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rubrique")
public class RubriqueController {
	
	@Autowired
    private RubriqueServices service;

	@Autowired
    RubriqueRepository rubriqueRepository ;
	
	/*
	@GetMapping("/{version}/rubriques")
	public ResponseEntity<List<Rubrique>> findRubriqueByVersion (@PathVariable Long version) {
	List <Rubrique> rub = (rubriqueRepository.findRubriqueByVersion(version));

		return ResponseEntity.ok(rub);
	}
	
	*/
	
	@GetMapping("/export")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		System.out.println("hello export");
		response.setContentType("application/octet-stream");
		String headerkey ="Content-Disposition";
		String headerValue = "attachment; filename=rubriques.xlsv";
		
		response.setHeader(headerkey, headerValue);
		//
		
		List<Rubrique> listRubrique = service.listAll();;
		RubriqueExeclExporter excelExporter = new RubriqueExeclExporter(listRubrique);
		excelExporter.export(response);
	}
}
