package br.com.erudio.services.V2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.custom.PersonConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.V2.PersonVO;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServicesV2 {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonConverter personConverter;
	
	public PersonVO create(PersonVO personVO) {
		Person entity = personConverter.convertToEntity(personVO);
		return personConverter.convertToVO(personRepository.save(entity));
	}

}
