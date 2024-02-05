package ca.sheridancollege.vutran.controllers;

import java.util.List;

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
public class KidController {
	private KidRepo kr;
	private PetRepo pr;
	@GetMapping("/")
	public String indexHTML(Model model) {
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		model.addAttribute("petType", PetType.values());
		model.addAttribute("kid", new Kid());
		model.addAttribute("pet", new Pet());
		return "index";
	}
	@GetMapping("/addKid")
	public String addKidHTML(Model model) {
		model.addAttribute("kid", new Kid());
		return "addKid";
	}
	@PostMapping("/addKid")
	public String kidFormSubmission(@ModelAttribute Kid kid, Model model) {
		kr.save(kid);
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());	
		model.addAttribute("petType", PetType.values());
		model.addAttribute("pet", new Pet());
		return "index";
	}
	//@PostMapping("/kid_findByAgeGreaterThan/{age}") 
	@PostMapping("/kid_findByAgeGreaterThan")
	//public String findKidsWithAgeGreaterThanX(@PathVariable("age") int age, Model model) {
	public String findKidsWithAgeGreaterThanX(Model model, @ModelAttribute Kid kid) {
		model.addAttribute("kid", new Kid());
		model.addAttribute("petType", PetType.values());
		List<Kid> kidList = kr.findByAgeGreaterThan(kid.getAge());
		model.addAttribute("kidsAgeGreaterThanX", kidList);
		model.addAttribute("pet", new Pet());
		return "index";
	}
	@PostMapping("/findKidsOwningPetType")
	public String findKidsOwningPetType(Model model, @ModelAttribute Pet pet) {
		model.addAttribute("kid", new Kid());
		model.addAttribute("", pr.findByFurryTrue());
		model.addAttribute("petType", PetType.values());
		model.addAttribute("pet", new Pet());
		
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		model.addAttribute("kid", new Kid());
		System.out.println(kr.findByPet_PetTypeEquals(pet.getPetType()));
		model.addAttribute("kidsPetType", kr.findByPet_PetTypeEquals(pet.getPetType()));
		return "index";
	}
	@PostMapping("/findKidsPetFurryTrue")
	public String findKidsPetFurryTrue(Model model, @ModelAttribute Pet pet) {
		model.addAttribute("kid", new Kid());
		model.addAttribute("", pr.findByFurryTrue());
		model.addAttribute("petType", PetType.values());
		model.addAttribute("pet", new Pet());
		
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		model.addAttribute("kid", new Kid());
		System.out.println(kr.findByPet_FurryIsTrue());
		model.addAttribute("kidsOwningFurryPet", kr.findByPet_FurryIsTrue());
		return "index";
	}
	//kidsHavePet
	@PostMapping("/kidsHavePet")
	public String kidsHavePet(Model model, @ModelAttribute Pet pet) {
		model.addAttribute("kid", new Kid());
		model.addAttribute("", pr.findByFurryTrue());
		model.addAttribute("petType", PetType.values());
		model.addAttribute("pet", new Pet());
		
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		model.addAttribute("kid", new Kid());
		System.out.println(kr.findByPetIsNotNull());
		model.addAttribute("kidsHavePet", kr.findByPetIsNotNull());
		return "index";
	}
}
