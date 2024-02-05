package ca.sheridancollege.vutran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.vutran.beans.Kid;
import ca.sheridancollege.vutran.beans.Pet;
import ca.sheridancollege.vutran.beans.PetType;
import ca.sheridancollege.vutran.repo.KidRepo;
import ca.sheridancollege.vutran.repo.PetRepo;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PetController {
	private PetRepo pr;
	private KidRepo kr;
	@GetMapping("/addPet")
	public String addPetHTML(Model model) {
		model.addAttribute("pet", new Pet());
		model.addAttribute("petType", PetType.values());
		return "addPet";
	}
	@PostMapping("/addPet")
	public String petFormSubmission(Model model, @ModelAttribute Pet pet) {
		Pet savedPet = pr.save(pet);
		Kid kid = new Kid();
		kid.setPet(savedPet);
		model.addAttribute("kid", kid);
		return "addKid";
	}
	@PostMapping("/findPetsFurryTrue")
	public String findPetsFurryTrue(Model model) {
		model.addAttribute("kid", new Kid());
		model.addAttribute("furryPets", pr.findByFurryTrue());
		model.addAttribute("petType", PetType.values());
		model.addAttribute("pet", new Pet());
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		System.out.println(pr.findByFurryTrue());
		return "index";
	}
	@PostMapping("/findPetsPetType")
	public String findPetsPetType(Model model, @ModelAttribute Pet pet) {
		model.addAttribute("kid", new Kid());
		model.addAttribute("", pr.findByFurryTrue());
		model.addAttribute("petType", PetType.values());
		model.addAttribute("pet", new Pet());
		
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		model.addAttribute("kid", new Kid());
		System.out.println(pr.findByPetType(pet.getPetType()));
		model.addAttribute("petPetType", pr.findByPetType(pet.getPetType()));
		return "index";
	}
}
