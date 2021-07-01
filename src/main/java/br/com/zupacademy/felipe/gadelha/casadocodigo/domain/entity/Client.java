package br.com.zupacademy.felipe.gadelha.casadocodigo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Email
	@Column(nullable = false, unique = true)
	private String email;
	@NotBlank
	@Column(nullable = false)
	private String name;
	@NotBlank
	@Column(nullable = false)
	private String lastName;
	@NotBlank
	@Column(nullable = false, unique = true, length = 14)
	private String document;
	@NotBlank
	@Column(nullable = false)
	private String address;
	@NotBlank
	@Column(nullable = false)
	private String complement;
	@NotBlank
	@Column(nullable = false)
	private String city;
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Nation nation;
	
	@ManyToOne
	private State state;
	@NotBlank
	@Column(nullable = false)
	private String phone;
	@NotBlank
	@Column(nullable = false)
	private String zipCode;

	public Client(Builder builder) {
		this.email = builder.email;
		this.name = builder.name;
		this.lastName = builder.lastName;
		this.document = builder.document;
		this.address = builder.address;
		this.complement = builder.complement;
		this.city = builder.city;
		this.nation = builder.nation;
		this.state = builder.state;
		this.phone = builder.phone;
		this.zipCode = builder.zipCode;
	}
	public static Builder builder() {
        return new Builder();
	}
	public static class Builder {
		private String email;
		private String name;
		private String lastName;
		private String document;
		private String address;
		private String complement;
		private String city;
		private Nation nation;
		private State state;
		private String phone;
		private String zipCode;
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public Builder document(String document) {
			this.document = document;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		public Builder complement(String complement) {
			this.complement = complement;
			return this;
		}
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		public Builder nation(Nation nation) {
			this.nation = nation;
			return this;
		}
		public Builder state(State state) {
			this.state = state;
			return this;
		}
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public Builder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}
		public Client build() {
			return new Client(this);
		}
	}
	public Long getId() {
		return id;
	}
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
	public Nation getNation() {
		return nation;
	}
	public State getState() {
		return state;
	}
	public String getPhone() {
		return phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", name=" + name + ", lastName=" + lastName + ", document="
				+ document + ", address=" + address + ", complement=" + complement + ", city=" + city + ", nation="
				+ nation + ", state=" + state + ", phone=" + phone + ", zipCode=" + zipCode + "]";
	}
}
