package br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.IsUniqueForNationValidator;

@Documented
@Constraint(validatedBy = {IsUniqueForNationValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsUniqueForNation {

	String message() default "br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.IsUniqueForNationValidator";
	
	Class<?> [] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}