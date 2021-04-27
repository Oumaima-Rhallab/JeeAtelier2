package ma.emsi.tpjpa1;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.tpjpa1.entities.patient;
import ma.emsi.tpjpa1.repositories.PatientRepository;

@SpringBootApplication
public class TpJpa1Application implements CommandLineRunner {
  @Autowired
	private PatientRepository patientRepository;
	
    public static void main(String[] args) {
		SpringApplication.run(TpJpa1Application.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
patientRepository.save(new patient(null,"hassan",new Date(),2300,false));	
patientRepository.save(new patient(null,"Aymen",new Date(),5000,false));	
patientRepository.save(new patient(null,"Oumaima",new Date(),6800,false));	
patientRepository.save(new patient(null,"Marwa",new Date(),2300,true));		
patientRepository.findAll().forEach(p->{
	System.out.println(p.toString());
});
System.out.println("**********");
patient patient=patientRepository.findById(5L).get();
System.out.println(patient.getNom());
System.out.println("**********");
Page<patient> patients= patientRepository.findByNomContains("a",PageRequest.of(0, 2));
patients.getContent().forEach(p->{
	System.out.println(p.toString());
}
);

System.out.println("**********");
List<patient> patients2= patientRepository.findByMalade(true);
patients.forEach(p->{
	System.out.println(p.toString());
}
);
System.out.println("**********");
List<patient> patients3= patientRepository.findByNomContainsAndMalade("m",true);
patients.forEach(p->{
	System.out.println(p.toString());
});
//patientRepository.deleteById(4L);
System.out.println("**********");

Page<patient> pagePatients= patientRepository.findAll(PageRequest.of(1, 2));
System.out.println("Nombre de page :"+pagePatients.getTotalPages());
List<patient> listPatients=pagePatients.getContent();
listPatients.forEach(p->{
	System.out.println(p.toString());
});


}
	}
