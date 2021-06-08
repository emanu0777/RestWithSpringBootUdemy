package br.com.erudio.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.V2.PersonVO;

@Service
public class PersonConverter {

	public PersonVO convertToVO(Person entity) {
		PersonVO vo = new PersonVO();
		vo.setId(entity.getId());
		vo.setAddress(entity.getAddress());
		vo.setFristName(entity.getFristName());
		vo.setLastName(entity.getLastName());
		vo.setGender(entity.getGender());
		vo.setBirthday(new Date());
		return vo;
	}
	
	
	public Person convertToEntity(PersonVO personVO) {
		Person entity = new Person();
		entity.setId(personVO.getId());
		entity.setAddress(personVO.getAddress());
		entity.setFristName(personVO.getFristName());
		entity.setLastName(personVO.getLastName());
		entity.setGender(personVO.getGender());
		return entity;
	}
}
