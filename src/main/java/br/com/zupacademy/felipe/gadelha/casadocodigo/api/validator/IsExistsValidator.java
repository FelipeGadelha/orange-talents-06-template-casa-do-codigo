package br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class IsExistsValidator implements ConstraintValidator<IsExists, Object> {

	private String domainAttribute;
	private Class<?> klass;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(IsExists params) {
		domainAttribute = params.fieldId();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		var query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + " =:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.isEmpty(), "Não existe " + klass.getSimpleName() + " com o " + domainAttribute + " : " + value);
		return !list.isEmpty();
	}
}