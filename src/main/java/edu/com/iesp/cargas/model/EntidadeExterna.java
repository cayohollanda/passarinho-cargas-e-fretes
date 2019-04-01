package edu.com.iesp.cargas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
public abstract class EntidadeExterna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "entidadeExterna")
	private List<Contato> contatos;
	
	@OneToMany()
	private List<Telefone> telefones;
	
	@Column
	private String email;

	@OneToOne
	private Endereco endereco;
	
	@Column
	private String nome;
	
	@Column
	private String cnpj;
	
	@Column
	private String razaoSocial;
	
}
