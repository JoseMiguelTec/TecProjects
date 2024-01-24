package es.tecdata.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MedirTiempoFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
		// Orden de ejecucion en el caso de tener varios filtros
		return 1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// pre
		// Tomar el tiempo de inicio
		long tiempoInicio = System.currentTimeMillis();

		// post es lo que hay dentro del .then()
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			// Tomar el tiempo final
			long tiempoFinal = System.currentTimeMillis();

			// Mostrar la diferencia de tiempo
			System.out.println("*********");
			System.out.println("Tiempo transcurrido:" + (tiempoFinal - tiempoInicio) + " mseg.");
			System.out.println("*********");
		}));
	}

}
