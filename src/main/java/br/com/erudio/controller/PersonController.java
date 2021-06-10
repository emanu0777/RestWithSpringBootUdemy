package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personService;
	
	@GetMapping(produces =  {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() {
		return personService.findAll();
	}

	@GetMapping(value = "/{idPerson}", produces =  {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("idPerson") Long idPerson) {
		return personService.findById(idPerson);
	}
	
	@DeleteMapping("/{idPerson}")
	public ResponseEntity<?> delete(@PathVariable("idPerson") Long idPerson) {
		personService.deleteById(idPerson);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces =  {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO savePersonVO(@RequestBody PersonVO person) {
		return personService.create(person);
	}
	
	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces =  {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.update(person);
	}
	
	
}
