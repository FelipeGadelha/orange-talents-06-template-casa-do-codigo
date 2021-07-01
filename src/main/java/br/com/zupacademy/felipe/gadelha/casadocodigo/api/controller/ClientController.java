package br.com.zupacademy.felipe.gadelha.casadocodigo.api.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.ClientRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.ClientRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private final ClientRepository clientRepository;
	
	@PersistenceContext
	private final EntityManager manager;
	
	public ClientController(ClientRepository clientRepository, EntityManager manager) {
		this.clientRepository = clientRepository;
		this.manager = manager;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClientRs> save(@RequestBody @Valid ClientRq clientRq, UriComponentsBuilder uriBuilder) {
		var client = clientRepository.save(clientRq.convert(manager));
		var uri = uriBuilder
				.path("/clients/{id}")
				.buildAndExpand(client.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new ClientRs(client));
	}
	
	
}
