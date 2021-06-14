package br.com.erudio.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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
		List<PersonVO> listReturn  = personService.findAll();
		if (CollectionUtils.isEmpty(listReturn)) {
			return null;
		}
		listReturn.forEach(p -> p.add(linkTo(methodOn(PersonController.class)
					.findById(p.getId())).withSelfRel()));
		
		return listReturn;
	}

	@GetMapping(value = "/{idPerson}", produces =  {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("idPerson") Long idPerson) {
		PersonVO personVO = personService.findById(idPerson);
		personVO.add(linkTo(methodOn(PersonController.class).findAll()).withRel("Lista de Produtos"));
		return personVO;
	}
	
	@DeleteMapping("/{idPerson}")
	public ResponseEntity<?> delete(@PathVariable("idPerson") Long idPerson) {
		personService.deleteById(idPerson);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces =  {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO savePersonVO(@RequestBody PersonVO person) {
		PersonVO personVO = personService.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getId())).withSelfRel());
		return personVO;
	}
	
	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces =  {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {		
		PersonVO personVO = personService.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getId())).withSelfRel());
		return personVO;
	}
	
	
}
