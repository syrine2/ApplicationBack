package ppe.projet.site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ppe.projet.site.entites.Bloc;
import ppe.projet.site.entites.Version;

@CrossOrigin("*")

@RepositoryRestResource(exported = true)
public interface VersionRepository extends JpaRepository <Version, Long> {

}
