package edu.com.iesp.cargas.model.cargos;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import edu.com.iesp.cargas.model.Funcionario;
import edu.com.iesp.cargas.model.Veiculo;

@Entity
public class Motorista extends Funcionario {
	
	@OneToOne
	private Veiculo veiculo; 

}
