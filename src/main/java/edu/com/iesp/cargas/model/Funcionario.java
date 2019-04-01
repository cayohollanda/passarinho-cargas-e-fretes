package edu.com.iesp.cargas.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public abstract class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	private String nome;
	
	private BigDecimal salario;
	
	private Cargo cargo;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Dependente> dependetes;
	
	@Transient
	private List<Telefone> telefones;
	
	private String email;
	
	@Transient
	private Endereco endereco;
	
}
