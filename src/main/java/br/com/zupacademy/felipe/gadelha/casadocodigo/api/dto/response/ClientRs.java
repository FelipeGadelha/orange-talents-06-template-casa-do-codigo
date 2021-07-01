package br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response;

import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity.Client;

public class ClientRs {

	private Long id;

	public ClientRs(Client client) {
		id = client.getId();
	}
	public Long getId() {
		return id;
	}
}
