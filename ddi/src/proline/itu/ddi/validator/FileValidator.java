package proline.itu.ddi.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import proline.itu.ddi.controller.Zemberek;

public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Zemberek.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "fileData", "fileData.required");
	}

}
