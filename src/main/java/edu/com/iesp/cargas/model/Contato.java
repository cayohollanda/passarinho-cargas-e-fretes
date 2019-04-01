package edu.com.iesp.cargas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Contato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9171890050862546515L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@ManyToOne
	private EntidadeExterna entidadeExterna;

	
}
