package com.projetoCep.pesquisaCep;

import com.projetoCep.pesquisaCep.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PesquisaCepApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PesquisaCepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menu();
	}
}
