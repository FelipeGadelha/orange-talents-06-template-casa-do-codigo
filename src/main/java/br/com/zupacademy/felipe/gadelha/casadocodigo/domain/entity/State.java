package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	private Nation nation;

	@Deprecated
	public State() { }
	
	public State(String name, Nation nation) {
		this.name = name;
		this.nation = nation;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Nation getNation() {
		return nation;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", nation=" + nation + "]";
	}
	
}
