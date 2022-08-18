package br.com.bb.trivia.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class SwaggerConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Jogo do Milhão")
                            .description("Você quer ganhar um MILHÃO de reais?")
                            .version("v0.0.1")
                    );
        }

    }
