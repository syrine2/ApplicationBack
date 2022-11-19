package ppe.projet.site;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import net.bytebuddy.utility.RandomString;
import ppe.projet.site.dao.BlocRepository;
import ppe.projet.site.dao.RubriqueRepository;
import ppe.projet.site.entites.Bloc;
import ppe.projet.site.entites.Rubrique;

@SpringBootApplication
public class Projet1Application implements CommandLineRunner {

	@Autowired
	private BlocRepository blocRepository;
	@Autowired
	private RubriqueRepository rubriqueRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(Projet1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		repositoryRestConfiguration.exposeIdsFor(Bloc.class,Rubrique.class);
	/*		
		Bloc b = new Bloc();
		b.setNom("S10.G00.00");
		b.setLibelle("Envoi");
		b.setDescriptions("hhhhh");
		Bloc b1 = new Bloc();
		b1.setNom("S10.G00.01");
		b1.setLibelle("Emetteur");
		b1.setDescriptions("hhhhh");
		Bloc b2 = new Bloc();
		b2.setNom("S10.G00.02");
		b2.setLibelle("Contact Emetteur");
		b2.setDescriptions("hhhhh");
		blocRepository.save(b);
		blocRepository.save(b1);
		blocRepository.save(b2); 
		blocRepository.save(new Bloc(0L,"S10.G00.00","Envoi","ffffff",null));
		blocRepository.save(new Bloc(1L,"S10.G00.01","Emetteur","ffffff",null));
		blocRepository.save(new Bloc(2L,"S10.G00.02","Contact Emetteur","ffffff",null));
		
		
		blocRepository.findAll().forEach(c->{
			for(int i=0;i<2;i++) {
			Rubrique Rb = new Rubrique();
			Random rnd = new Random();
			Rb.setZoneDSN(c.getNom() +'.'+'0'+(i+1));
			Rb.setCommentaire(RandomString.make(18));
			Rb.setLibelle(RandomString.make(18));
			Rb.setPhase(RandomString.make(18));
			Rb.setBloc(c);
			Rb.setIdBloc(c.getId());
			rubriqueRepository.save(Rb);
			}
		}); 
	*/
	}

}
