package br.com.fill.samples.balancedbrackets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BalancedBracketsApplication implements CommandLineRunner {

	@Autowired
	private BracketsValidator validator;
	
	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
			System.out.println("\n\n###########################################");
			System.out.println("### Validando balanceamento de brackets ###");
			System.out.println("###########################################");
			for (String cenario : args) {
				System.out.print("Validando cenário " + cenario);
				System.out.println(validator.isValid(cenario) ? " = Válido!" : " = Inválido!");
			}
		} else {
			System.out.println("Por favor, passe argumentos");
		}
		System.out.println("\n\n");
	}

	public static void main(String[] args) {
		SpringApplication.run(BalancedBracketsApplication.class, args);
	}
}
