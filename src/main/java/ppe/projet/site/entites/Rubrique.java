package ppe.projet.site.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Rubrique implements java.io.Serializable {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String zoneDSN;
	
	private String libelle ;
	
	private String phase;
	
	private String commentaire;
	
	@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bloc")
	private Bloc bloc ;


    
    private Long idBloc;

	





	public Rubrique(Long id, String zoneDSN, String libelle, String phase, String commentaire, Bloc bloc, Long idBloc) {
		super();
		this.id = id;
		this.zoneDSN = zoneDSN;
		this.libelle = libelle;
		this.phase = phase;
		this.commentaire = commentaire;
		this.bloc = bloc;
		this.idBloc = idBloc;
	}

	public Rubrique() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZoneDSN() {
		return zoneDSN;
	}

	public void setZoneDSN(String zoneDSN) {
		this.zoneDSN = zoneDSN;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Bloc getBloc() {
		return bloc;
	}

	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}

	public Long getIdBloc() {
		return idBloc;
	}

	public void setIdBloc(Long idBloc) {
		this.idBloc = idBloc;
	}
    
    
	
	
	

}
