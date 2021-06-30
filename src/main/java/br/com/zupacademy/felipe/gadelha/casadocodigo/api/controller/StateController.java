package br.com.zupacademy.felipe.gadelha.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.CategoryRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.StateRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.CategoryRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.StateRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.CategoryRepository;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.NationRepository;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateController {

	private final StateRepository stateRepository;
	private final NationRepository nationRepository;
	
	public StateController(StateRepository stateRepository, NationRepository nationRepository) {
		this.stateRepository = stateRepository;
		this.nationRepository = nationRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@RequestBody @Valid StateRq stateRq, UriComponentsBuilder uriBuilder) {
		var state = stateRepository.save(stateRq.convert(nationRepository));
		var uri = uriBuilder
				.path("/states/{id}")
				.buildAndExpand(state.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new StateRs(state));
	}
	
	
}
