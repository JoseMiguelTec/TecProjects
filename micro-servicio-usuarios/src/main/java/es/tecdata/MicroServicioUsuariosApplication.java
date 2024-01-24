package es.tecdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioUsuariosApplication.class, args);
	}

}
