package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.State;

public class StateRs {

	private Long id;
	private String name;
	private String nationName;

	public StateRs(State state) {
		id = state.getId();
		name = state.getName();
		nationName = state.getNation().getName();
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getNationName() {
		return nationName;
	}
	
	

}
