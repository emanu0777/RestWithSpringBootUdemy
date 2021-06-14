package br.com.erudio.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

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

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "BookEndPoint", description = "Endpoints para operações na Entidade Book", tags = {"BookEndpoint"})
@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@ApiOperation(value = "Find all books")
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml" })
	public List<BookVO> findAll() {
		List<BookVO> listBook = bookService.findAll();
		
		if (CollectionUtils.isEmpty(listBook)) {
			return null;
		}
		listBook.stream().forEach(b -> b.add(linkTo(methodOn(BookController.class).findById(b.getId())).withSelfRel()));
		return listBook;
	}
	
	@ApiOperation(value = "Find book from id")
	@GetMapping(path = "/{idBook}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable ("idBook") Long idBook) {
		BookVO bookVO = bookService.findById(idBook);
		bookVO.add(linkTo(methodOn(BookController.class).findAll()).withRel("Lista de books"));
		return bookVO;
	}
	
	@ApiOperation(value = "Save new book")
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, 
			produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO bookVO) {
		BookVO bookVOCriado = bookService.create(bookVO);
		bookVOCriado.add(linkTo(methodOn(BookController.class).findById(bookVOCriado.getId())).withSelfRel());
		return bookVOCriado;
	}
	
	@ApiOperation(value = "Delete book from id")
	@DeleteMapping(path = "{idBook}")
	public ResponseEntity<?> deleteById(@PathVariable("idBook") Long idBook) {
		bookService.deleteById(idBook);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Update book")
	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
			produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO bookVO) {
		BookVO bookVOAtualizado = bookService.update(bookVO);
		bookVOAtualizado.add(linkTo(methodOn(BookController.class).findById(bookVOAtualizado.getId())).withSelfRel());
		return bookVOAtualizado;
	}
	
}
