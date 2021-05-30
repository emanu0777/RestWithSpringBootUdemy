package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.utils.NumberUtils;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, informe um numero");
		}
		Double valor = NumberUtils.convertValueToDouble(numberOne) + NumberUtils.convertValueToDouble(numberTwo);
		
		return valor;
	
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, informe um numero");
		}
		Double valor = NumberUtils.convertValueToDouble(numberOne) - NumberUtils.convertValueToDouble(numberTwo);
		
		return valor;
	
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, informe um numero");
		}
		Double valor = NumberUtils.convertValueToDouble(numberOne) * NumberUtils.convertValueToDouble(numberTwo);
		
		return valor;
	
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, informe um numero");
		}
		Double valor = NumberUtils.convertValueToDouble(numberOne)/NumberUtils.convertValueToDouble(numberTwo);
		
		return valor;
	
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, informe um numero");
		}
		Double valor = (NumberUtils.convertValueToDouble(numberOne) + NumberUtils.convertValueToDouble(numberTwo))/2;
		
		return valor;
	
	}
		
	@RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
	public Double raizQuadrada(@PathVariable("number") String number) {
		if (!NumberUtils.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Por favor, informe um numero");
		}
		Double valor = Math.sqrt(NumberUtils.convertValueToDouble(number));
		return valor;
	
	}
}
