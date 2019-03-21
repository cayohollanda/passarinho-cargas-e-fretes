package edu.com.iesp.cargas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity(name = "TB_CONTATO")
@NoArgsConstructor
public class Contato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9171890050862546515L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long Id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
}
