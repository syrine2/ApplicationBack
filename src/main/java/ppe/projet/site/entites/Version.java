package ppe.projet.site.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Version implements java.io.Serializable {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long idversion ;
	
	private String nom ;
	

	
	@JsonManagedReference
	@OneToMany(mappedBy = "version")
	private Collection<Bloc> blocs;
	
	



	public Version(Long idversion, String nom, Collection<Bloc> blocs) {
		super();
		this.idversion = idversion;
		this.nom = nom;
		this.blocs = blocs;
	}


	public Version() {
		super();
	}


	public Long getId() {
		return idversion;
	}


	public void setId(Long id) {
		this.idversion = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}




	public Collection<Bloc> getBlocs() {
		return blocs;
	}


	public void setBlocs(Collection<Bloc> blocs) {
		this.blocs = blocs;
	}
	
	
	
	
	
}
