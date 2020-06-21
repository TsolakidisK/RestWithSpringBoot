package com.tsolakidis.springbootbackend;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@RequestMapping(value ="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}

	private double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String newNumber = strNumber.replaceAll(",", ".");
		if (isNumeric(newNumber)) return Double.parseDouble(newNumber);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String newNumber = strNumber.replaceAll(",", ".");
		return newNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}