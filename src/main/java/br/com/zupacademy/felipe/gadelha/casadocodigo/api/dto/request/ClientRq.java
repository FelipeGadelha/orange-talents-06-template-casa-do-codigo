package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.CpfOrCnpj;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.IsExists;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.validator.annotation.UniqueValue;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Client;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Nation;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.State;

public class ClientRq {
	
	@NotBlank @Email
	@UniqueValue(domainClass = Client.class,
		fieldName = "email",
		message = "Já existe um email com esse valor")
	private String email;
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	@NotBlank @Length(max = 14)
	@UniqueValue(domainClass = Client.class,
			fieldName = "document",
			message = "Já existe um CPF/CNPJ com esse valor")
	@CpfOrCnpj(message = "CPF ou CNPJ inválido")
	private String document;
	@NotBlank
	private String address;
	@NotBlank
	private String complement;
	@NotBlank
	private String city;
	@NotNull
	@IsExists(
			domainClass = Nation.class,
			fieldId = "id",
			message = "Não existe País com este ID")
	private Long nationId;

	private Long stateId;
	@NotBlank
	private String phone;
	@NotBlank
	private String zipCode;

	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDocument() {
		return document;
	}
	public String getAddress() {
		return address;
	}
	public String getComplement() {
		return complement;
	}
	public String getCity() {
		return city;
	}
	public Long getNationId() {
		return nationId;
	}
	public Long getStateId() {
		return stateId;
	}
	public String getPhone() {
		return phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public Client convert(EntityManager manager) {
		var nation = manager.find(Nation.class, nationId);
		Assert.state(Objects.nonNull(nation),"Valor inválido, não existe Nation com o id : " + nationId);
		State state = (Objects.nonNull(stateId)) ? manager.find(State.class, stateId) : null;
		return Client
				.builder()
				.email(email)
				.name(name)
				.lastName(lastName)
				.document(document)
				.city(city)
				.address(address)
				.complement(complement)
				.nation(nation)
				.state(state)
				.phone(phone)
				.zipCode(zipCode)
				.build();
	}
}
