package br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.StateRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.IsUniqueForNation;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Nation;

public class IsUniqueForNationValidator implements ConstraintValidator<IsUniqueForNation, Object>{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		var stateRq = (StateRq) value;
		Long nationId = stateRq.getNationId();
		String nameState = stateRq.getName();
		System.out.println(nationId);
		System.out.println(nameState);
		if (Objects.isNull(manager.find(Nation.class, nationId))) {
			return false;
		}
		List<?> list = manager.createQuery("select s from State s where s.nation.id =:pNation and s.name =:pState")
			.setParameter("pNation", nationId)
			.setParameter("pState", nameState)
			.getResultList();
		return list.isEmpty();
	}
}
