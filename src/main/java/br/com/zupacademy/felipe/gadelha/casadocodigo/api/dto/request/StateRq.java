package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.IsExists;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.IsUniqueForNation;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Nation;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.State;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.NationRepository;

@IsUniqueForNation(message = "Já existe estado com esse nome no país escolhido")
public class StateRq {

	@NotBlank
	private String name;
	@NotNull
	@IsExists(
			domainClass = Nation.class,
			fieldId = "id",
			message = "Não existe país com este ID")
	private Long nationId;
	
	public String getName() {
		return name;
	}
	public Long getNationId() {
		return nationId;
	}
	public State convert(NationRepository repository) {
		Optional<Nation> optional = repository.findById(nationId);
		Assert.state(optional.isPresent(), "Não existe país com este ID");
		return new State(name, optional.get());
	}
}
