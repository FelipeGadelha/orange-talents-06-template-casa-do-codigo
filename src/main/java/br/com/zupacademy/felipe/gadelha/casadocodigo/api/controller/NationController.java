package br.com.zupacademy.felipe.gadelha.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.request.NationRq;
import br.com.zupacademy.felipe.gadelha.casadocodigo.api.dto.response.NationRs;
import br.com.zupacademy.felipe.gadelha.casadocodigo.domain.repository.NationRepository;

@RestController
@RequestMapping("/nations")
public class NationController {

	private final NationRepository nationRepository;
	
	public NationController(NationRepository nationRepository) {
		this.nationRepository = nationRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<NationRs> save(@RequestBody @Valid NationRq nationRq, UriComponentsBuilder uriBuilder) {
		var nation = nationRepository.save(nationRq.convert());
		var uri = uriBuilder
				.path("/nations/{id}")
				.buildAndExpand(nation.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new NationRs(nation));
	}
	
	
}
