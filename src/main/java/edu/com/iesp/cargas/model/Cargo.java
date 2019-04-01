package edu.com.iesp.cargas.model;

import edu.com.iesp.cargas.model.cargos.Motorista;
import edu.com.iesp.cargas.model.cargos.ASG;
import edu.com.iesp.cargas.model.cargos.Carregador;
import edu.com.iesp.cargas.model.cargos.Diretor;
import edu.com.iesp.cargas.model.cargos.Gerente;
import edu.com.iesp.cargas.model.cargos.Mecanico;
import edu.com.iesp.cargas.model.cargos.Supervisor;

public enum Cargo {

	GERENTE{
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new Gerente();
		}
	},
	DIRETOR {
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new Diretor();
		}
	},
	SUPERVISOR {
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new Supervisor();
		}
	},
	MOTORISTA {
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new Motorista();
		}
	},
	MECANICO {
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new Mecanico();
		}
	},
	CARREGADOR {
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new Carregador();
		}
	},
	ASG {
		@Override
		public Funcionario obterFuncionario() {
			// TODO Auto-generated method stub
			return new ASG();
		}
	};
	
	public abstract Funcionario obterFuncionario();
}
