package ca.sheridancollege.vutran.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Kid;
import ca.sheridancollege.vutran.beans.PetType;

public interface KidRepo extends JpaRepository<Kid, Long> {
	//Find all kids with an age greater than some Integer value
	public List<Kid> findByAgeGreaterThan(int age);
	//Find all kids who own a particular PetType
	public List<Kid> findByPet_PetTypeEquals(PetType petType);
	// Find all kids who own a furry pet
	public List<Kid> findByPet_FurryIsTrue();
	// Find all kids who own a pet
	public List<Kid> findByPetIsNotNull();
}
