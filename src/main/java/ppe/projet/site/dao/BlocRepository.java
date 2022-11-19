package ppe.projet.site.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ppe.projet.site.entites.Bloc;

@CrossOrigin("*")

@RepositoryRestResource(exported = true)
public interface BlocRepository extends JpaRepository <Bloc, Long> {

	@RestResource(path ="/blocs")
	@Query("select v.blocs from Version v where v.idversion like :x")
	public List<Bloc> findBlocByVersion (@Param("x") Long vr);

}
