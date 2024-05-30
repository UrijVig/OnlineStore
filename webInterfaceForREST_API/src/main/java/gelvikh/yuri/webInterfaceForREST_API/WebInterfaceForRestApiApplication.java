package gelvikh.yuri.webInterfaceForREST_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;




@SpringBootApplication
public class WebInterfaceForRestApiApplication {
	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}

	public static void main(String[] args) {
		SpringApplication.run(WebInterfaceForRestApiApplication.class, args);
	}

}
