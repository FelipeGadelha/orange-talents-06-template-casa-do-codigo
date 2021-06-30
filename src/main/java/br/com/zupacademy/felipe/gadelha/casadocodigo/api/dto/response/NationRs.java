package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Nation;

public class NationRs {

	private String name;

	public NationRs(Nation nation) {
		name = nation.getName();
	}
	public String getName() {
		return name;
	}
}
