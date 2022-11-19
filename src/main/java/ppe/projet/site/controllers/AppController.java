package ppe.projet.site.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ppe.projet.site.dao.BlocRepository;
import ppe.projet.site.dao.RubriqueRepository;
import ppe.projet.site.dao.VersionRepository;
import ppe.projet.site.entites.Bloc;
import ppe.projet.site.entites.Rubrique;
import ppe.projet.site.entites.Version;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/app")
public class AppController {
	
	@Autowired
    RubriqueRepository rubriqueRepository ;
	
	@Autowired
	BlocRepository blocRepository;
	
	@Autowired
	VersionRepository versionRepository;
	

	@GetMapping("/rubriques")
	  public List<Rubrique> getAllRubriques() {
	    
		return rubriqueRepository.findAll();
	  }
	
	@GetMapping("/rubriques/{id}")
	public ResponseEntity<Rubrique> getRubriqueById (@PathVariable Long id) {
		Rubrique rub = rubriqueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rubrique not exist with id :" + id));
		return ResponseEntity.ok(rub);
	}
	@PutMapping("/rubriques/{id}")
	  public ResponseEntity<Rubrique> updateRubrique(@PathVariable("id") long id, @RequestBody Rubrique rubrique) {
	    Optional<Rubrique> rubriqueData = rubriqueRepository.findById(id);
	    if (rubriqueData.isPresent()) {
	    	Rubrique _rubrique = rubriqueData.get();
	    	_rubrique.setLibelle(rubrique.getLibelle()!=null ?rubrique.getLibelle() :_rubrique.getLibelle());
	    	_rubrique.setCommentaire(rubrique.getCommentaire()!=null ? rubrique.getCommentaire() :_rubrique.getCommentaire());
	    	_rubrique.setPhase(rubrique.getPhase()!=null ? rubrique.getPhase() :_rubrique.getPhase());
	    	_rubrique.setZoneDSN(rubrique.getZoneDSN()!=null ? rubrique.getZoneDSN() : _rubrique.getZoneDSN());
	    	      
	      return new ResponseEntity<>(rubriqueRepository.save(_rubrique), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/rubriques/{id}")
	  public ResponseEntity<HttpStatus> deleteRubrique(@PathVariable("id") long id) {
	    try {
	      rubriqueRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PostMapping("/blocs/{blocId}/rubriques")
	  public ResponseEntity<Rubrique> createRubrique(@PathVariable(value = "blocId") Long blocId,
	      @RequestBody Rubrique rubriqueRequest) {
		Rubrique rubrique = blocRepository.findById(blocId).map(bloc -> {
			bloc.getRubriques().add(rubriqueRequest);
	      return rubriqueRepository.save(rubriqueRequest);
	    }).orElseThrow(() -> new ResourceNotFoundException("Not found Bloc with id = " + blocId));
	    return new ResponseEntity<>(rubrique, HttpStatus.CREATED);
	  }
	
	@GetMapping("/blocs")
	  public List<Bloc> getAllBlocs() {
	    
		return blocRepository.findAll();
	  }
	
	@GetMapping("/blocs/{id}")
	public ResponseEntity<Bloc> getBlocById (@PathVariable Long id) {
		Bloc bl = blocRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bloc not exist with id :" + id));
		return ResponseEntity.ok(bl);
	}
	
	@PutMapping("/blocs/{id}")
	  public ResponseEntity<Bloc> updateBloc(@PathVariable("id") long id, @RequestBody Bloc bloc) {
	    Optional<Bloc> blocData = blocRepository.findById(id);
	    if (blocData.isPresent()) {
	    	 Bloc _bloc = blocData.get();
	    	_bloc.setLibelle(bloc.getLibelle()!=null ?bloc.getLibelle() :_bloc.getLibelle());
	    	_bloc.setDescriptions(bloc.getDescriptions()!=null ? bloc.getDescriptions() :bloc.getDescriptions());
	    	_bloc.setNom(bloc.getNom()!=null ? bloc.getNom() :_bloc.getNom());

	    	      
	      return new ResponseEntity<>(blocRepository.save(_bloc), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/blocs/{id}")
	  public ResponseEntity<HttpStatus> deleteBloc(@PathVariable("id") long id) {
	    try {
	      blocRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PostMapping("/blocs")
	  public ResponseEntity<Bloc> createTutorial(@RequestBody Bloc bloc) {
	    try {
	      Bloc _bloc = blocRepository
	          .save(bloc);
	      return new ResponseEntity<>(_bloc, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/versions")
	  public List<Version> getAllVersions() {
	    
		return versionRepository.findAll();
	  }
	

}
