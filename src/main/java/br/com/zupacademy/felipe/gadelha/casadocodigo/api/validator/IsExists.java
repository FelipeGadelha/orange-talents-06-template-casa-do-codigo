package br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {IsExistsValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsExists {
	
	String message() default "br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.IsExistsValidator";
	
	Class<?> [] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	String fieldId();
	
	Class<?> domainClass();
}
