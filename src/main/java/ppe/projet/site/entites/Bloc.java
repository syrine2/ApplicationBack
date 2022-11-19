package ppe.projet.site.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Bloc implements java.io.Serializable {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id ;
	
	private String nom ;
	
	private String libelle ;
	
	private String descriptions ;


	@JsonManagedReference
	@OneToMany(mappedBy = "bloc")
	private Collection<Rubrique> rubriques;
	
	@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="version")
	private Version version ;

	

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Bloc(Long id, String nom, String libelle, String descriptions, Collection<Rubrique> rubriques,
			Version version) {
		super();
		this.id = id;
		this.nom = nom;
		this.libelle = libelle;
		this.descriptions = descriptions;
		this.rubriques = rubriques;
		this.version = version;
	}

	public Bloc() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Collection<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(Collection<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}
	
	
}
