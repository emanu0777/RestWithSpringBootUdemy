package br.com.erudio.controller.V2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.V2.PersonVO;
import br.com.erudio.services.V2.PersonServicesV2;

@RestController
@RequestMapping("/person/V2")
public class PersonControllerV2 {

	@Autowired
	private PersonServicesV2 personService;
	
	
	@PostMapping
	public PersonVO savePersonVO(@RequestBody PersonVO person) {
		return personService.create(person);
	}
	
}
