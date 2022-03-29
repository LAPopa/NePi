package com.codecool.nepi;

import com.codecool.nepi.model.useraccounts.Admin;
import com.codecool.nepi.model.useraccounts.User;
import com.codecool.nepi.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NepiApplication {

	private static final Logger log = LoggerFactory.getLogger(NepiApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(NepiApplication.class, args);
	}

	@Bean
	public CommandLineRunner testAdminLogin(LoginRepository loginRepository) {
		return (args) -> {
			loginRepository.save(new Admin("Mimi","Moe","01234","test@mail.com","1234"));

			log.info("Current admin accounts ::");
			for (Admin admin : loginRepository.findAll()) {
				log.info(admin.toString());
			}
		};
	}

}

