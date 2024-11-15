package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			RestaurantQueryService restaurantService = context.getBean(RestaurantQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float rating = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findRestaurantsByNameAndRating with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Rating: " + rating);

			restaurantService.findRestaurantsByNameAndRating(name, rating)
					.forEach(System.out::println);
		};
	}
}

