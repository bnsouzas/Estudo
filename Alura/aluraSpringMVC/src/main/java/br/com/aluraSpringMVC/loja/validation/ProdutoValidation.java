package br.com.aluraSpringMVC.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.aluraSpringMVC.loja.models.Produto;

public class ProdutoValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Produto produto = (Produto)target;
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		if (produto.getPaginas() <= 0){
			errors.rejectValue("paginas", "field.required");
		}
	}

}
