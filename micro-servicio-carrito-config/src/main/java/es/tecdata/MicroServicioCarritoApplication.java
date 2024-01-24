package es.tecdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import es.tecdata.persistence.CarritoDAO;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroServicioCarritoApplication implements CommandLineRunner {

	@Autowired
	private CarritoDAO carritoDao;

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioCarritoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Eliminar todos los datos
		carritoDao.deleteAll();
	}

}
