package es.tecdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.tecdata.models.Producto;
import es.tecdata.persistence.ProductosDAO;

@SpringBootApplication
public class MicroServicioProductosApplication implements CommandLineRunner {

	@Autowired
	private ProductosDAO productosDAO;

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioProductosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertar 5 registros en BBD
		productosDAO.insert(new Producto(1L, "Pantalla", 149.50));
		productosDAO.insert(new Producto(2L, "Teclado", 37.95));
		productosDAO.insert(new Producto(3L, "Raton", 25.50));
		productosDAO.insert(new Producto(4L, "Impresora", 89.75));
		productosDAO.insert(new Producto(5L, "Scanner", 215.90));

		// Mostrar todos los productos en consola
		productosDAO.findAll().stream().forEach(System.out::println);
		System.out.println("---------");

		// Buscar un producto
		productosDAO.findById(4L);
	}

}
