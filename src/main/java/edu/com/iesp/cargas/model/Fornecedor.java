package edu.com.iesp.cargas.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
public class Fornecedor extends EntidadeExterna {

	private String cpf;
	
}
