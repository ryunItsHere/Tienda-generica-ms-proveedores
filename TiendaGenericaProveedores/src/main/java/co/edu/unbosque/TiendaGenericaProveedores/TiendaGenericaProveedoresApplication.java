package co.edu.unbosque.TiendaGenericaProveedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"co.edu.unbosque.TiendaGenericaProveedores",
		"co.edu.unbosque.TiendaGenericaProveedores.controller",
		"co.edu.unbosque.TiendaGenericaProveedores.services",
		"co.edu.unbosque.TiendaGenericaProveedores.repository",
		"co.edu.unbosque.TiendaGenericaProveedores.model"
})
public class TiendaGenericaProveedoresApplication
		extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(
				TiendaGenericaProveedoresApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(
				TiendaGenericaProveedoresApplication.class, args);
	}
}