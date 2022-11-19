package ppe.projet.site.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import ppe.projet.site.entites.Rubrique;

@Repository
public interface RubriqueRepository extends JpaRepository <Rubrique, Long> {

//	@RestResource(path ="/selectedRubriques")
//	public List<Rubrique> findBySelectedIsTrue();
	
	@RestResource(path ="/RubriquesByKeyword")
	@Query("select r from Rubrique r where r.zoneDSN like :x ")
	public List<Rubrique> chercher(@Param("x")String mc);
	
	@RestResource(path ="/RubriqueById")
	@Query("select r from Rubrique r where r.id like :x")
	public List<Rubrique> findRubriqueById (@Param("x") Long mc);
	
	/*
	@RestResource(path ="/rubriques")
	@Query("select v.rubriques from Version v where v.idversion like :x")
	public List<Rubrique> findRubriqueByVersion (@Param("x") Long vr);
	*/
	
	
	


	
}
