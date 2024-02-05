package ca.sheridancollege.vutran.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Pet;
import ca.sheridancollege.vutran.beans.PetType;

public interface PetRepo extends JpaRepository<Pet, Long> {
	//Find all pets who are furry (meaning where furry is true)
	public List<Pet> findByFurryTrue();
	//Find all pets matching a PetType (meaning where a retrieved PetType value matches)
	public List<Pet> findByPetType(PetType petType);
}
