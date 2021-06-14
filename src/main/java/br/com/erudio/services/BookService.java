package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.BookVO;
import br.com.erudio.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BookVO create(BookVO bookVO) {
		Book entity = DozerConverter.parseObject(bookVO, Book.class);
		return DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
	}
	
	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(bookRepository.findAll(), BookVO.class);
	}
	
	public BookVO findById(Long id) {
		Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Por favor, insira um id válido!"));
		BookVO bookVO = DozerConverter.parseObject(entity, BookVO.class);
		
		return bookVO;
	}
	
	public void deleteById(Long id) {
		BookVO bookVO = findById(id);
		bookRepository.deleteById(bookVO.getId());
	}
	
	public BookVO update(BookVO bookVO) {
		BookVO bookParaAtualizar = findById(bookVO.getId());
		bookParaAtualizar = bookVO;
		Book bookAtualizado = DozerConverter.parseObject(bookParaAtualizar, Book.class);
		return DozerConverter.parseObject(bookAtualizado, BookVO.class);	
	}
	
}
