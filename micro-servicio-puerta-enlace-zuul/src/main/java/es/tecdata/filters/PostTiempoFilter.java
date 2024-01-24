package es.tecdata.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// Activar o desactivar el filtro
		// Si devuelve true se ejecuta el metodo run()
		// Si devuelve false lo ignora
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// En este metodo se ejectura el contenido del filtro

		// Tomar el tiempo de final
		Long tiempoFinal = System.currentTimeMillis();

		// Lo guardo como atributo de peticion

		RequestContext context = RequestContext.getCurrentContext();
		long tiempoInicial = (long) context.getRequest().getAttribute("tiempoInicio");

		// Mostrar la diferencia de tiempos
		System.out.println("**********");
		System.out.println("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial) + "mseg.");
		System.out.println("**********");
		return null;
	}

	@Override
	public String filterType() {
		// Hay que retornar uno de estos valores:
		// "pre" -> se ejectura antes de que el request sea enrutado
		// "post" -> se ejecuta despues del request
		// "route" -> se ejecuta en el enrutado
		return "post";
	}

	@Override
	public int filterOrder() {
		// Establece el orden de ejecucion en el caso de tener varios filtros
		return 1;
	}

}
