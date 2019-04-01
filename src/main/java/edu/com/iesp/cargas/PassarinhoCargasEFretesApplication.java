package edu.com.iesp.cargas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.com.iesp.cargas.model.Cargo;
import edu.com.iesp.cargas.model.Funcionario;
import edu.com.iesp.cargas.model.cargos.Gerente;

@SpringBootApplication
public class PassarinhoCargasEFretesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassarinhoCargasEFretesApplication.class, args);
		
		
	}

}
