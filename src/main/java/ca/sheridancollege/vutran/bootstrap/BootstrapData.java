package ca.sheridancollege.vutran.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.vutran.beans.Kid;
import ca.sheridancollege.vutran.beans.Pet;
import ca.sheridancollege.vutran.beans.PetType;
import ca.sheridancollege.vutran.repo.KidRepo;
import ca.sheridancollege.vutran.repo.PetRepo;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private KidRepo kr;
	private PetRepo pr;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		Pet pet1 = Pet.builder()
				.furry(true)
				.name("Coco")
				.petType(PetType.DOG)
				.build();
		Pet pet2 = Pet.builder()
				.furry(false)
				.name("Jim")
				.petType(PetType.CAT)
				.build();
		pr.save(pet1);
		pr.save(pet2);
		
		Kid david = Kid.builder()
				.name("David")
				.age(5)
				.pet(pet2)
				.build();
		Kid linda = Kid.builder()
				.name("Linda")
				.age(6)
				.build();
		Kid peter = Kid.builder()
				.name("Peter")
				.age(7)
				.pet(pet1)
				.build();
		kr.save(david);
		kr.save(linda);
		kr.save(peter);
	}

}
