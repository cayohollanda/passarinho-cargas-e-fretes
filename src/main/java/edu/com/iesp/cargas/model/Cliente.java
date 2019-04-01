package edu.com.iesp.cargas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4326775709351680722L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Transient
	private List<Contato> contatos;
	@Transient
	private List<String> telefones;
	@Transient
	private List<String> emails;
	@Transient
	private List<String> endereco;
	
	private String nome;
	
}
