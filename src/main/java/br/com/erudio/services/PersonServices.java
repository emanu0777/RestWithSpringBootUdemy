package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository personRepository;
	
	public Person create(Person entity) {
		return personRepository.save(entity);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Por favor, insira um id válido"));
	}
	
	public void deleteById(Long id) {
		Person entity = findById(id);
		personRepository.delete(entity);
	}
	
	public Person update(Person person) {
		Person entity = findById(person.getId());
		entity = person;
		return personRepository.save(entity);
	}
}
