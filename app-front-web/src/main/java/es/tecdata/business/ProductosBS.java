package es.tecdata.business;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.tecdata.models.Carrito;
import es.tecdata.models.Producto;

@Service
public class ProductosBS implements IProductosBS {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Producto> obtenerTodos() {
		String url = "http://localhost:8091/api/productos/listar";
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);
		Object[] objects = responseEntity.getBody();
		ObjectMapper mapper = new ObjectMapper();
		return Arrays.stream(objects).map(object -> mapper.convertValue(object, Producto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Producto buscar(Long id) {
		String url = "http://localhost:8091/api/productos/buscar/{codigo}";
		Producto producto = null;
		try {
			producto = restTemplate.getForObject(url, Producto.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			producto = new Producto();
		}
		return producto;
	}

	@Override
	public Carrito crear(String usuario) {
		String url = "http://localhost:8091/api/carrito/crear/{usuario}";
		return restTemplate.postForObject(url, null, Carrito.class, usuario);
	}

	@Override
	public Carrito consultar(String usuario) {
		String url = "http://localhost:8091/api/carrito/consultar/{usuario}";
		return restTemplate.getForObject(url, Carrito.class, usuario);
	}

	@Override
	public void agregar(Long id, int cantidad, String usuario) {
		String url = "http://localhost:8091/api/carrito/agregar/id/{id}/cantidad/{cantidad}/usuario/{usuario}";
		restTemplate.put(url, null, id, cantidad, usuario);

	}

	@Override
	public void eliminar(Long id, String usuario) {
		String url = "http://localhost:8091/api/carrito/eliminar/id/{id}/usuario/{usuario}";
		restTemplate.delete(url, id, usuario);
	}

}
