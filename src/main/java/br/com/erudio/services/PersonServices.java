package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository personRepository;
	
	public PersonVO create(PersonVO personVO) {
		Person entity = DozerConverter.parseObject(personVO, Person.class);
		return DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
	}
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Por favor, insira um id válido"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public void deleteById(Long id) {
		PersonVO personVO = findById(id);
		Person entity = DozerConverter.parseObject(personVO, Person.class);
		personRepository.delete(entity);
	}
	
	public PersonVO update(PersonVO person) {
		PersonVO personVOParaAtualizar = findById(person.getId());
		personVOParaAtualizar = person;
		Person personAtualizado =  personRepository.save(DozerConverter.parseObject(personVOParaAtualizar, Person.class));
		return DozerConverter.parseObject(personAtualizado, PersonVO.class);
	}
}
