package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Nation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	@OneToMany
	private List<State> states = new ArrayList<>();
	
	@Deprecated
	public Nation() { }
	
	public Nation(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<State> getStates() {
		return states;
	}

	@Override
	public String toString() {
		return "Nation [id=" + id + ", name=" + name + ", states=" + states + "]";
	}
	
}
