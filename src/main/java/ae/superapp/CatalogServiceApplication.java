package ae.superapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import static ae.superapp.catalog.constants.SwaggerConstants.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Main Application class for Catalog Service
 *
 * @since 2023-07-10
 */
@OpenAPIDefinition(
		info = @Info(title = OPEN_API_APP_TITLE,
				description = OPEN_API_APP_DESCRIPTION,
				version = OPEN_API_APP_VERSION),
		servers = {@Server(url = LOCAL_SERVER_BASE_URL, description = LOCAL_SERVER_DESCRIPTION)})
@SpringBootApplication
public class CatalogServiceApplication {

	/**
	 * main method of CatalogServiceApplication
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
