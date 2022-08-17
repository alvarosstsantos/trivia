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
                            .title("Jogo de Milhao")
                            .description("Vai ficar faltando a musiquinha e os universitários!")
                            .version("v0.0.1")
                    );
        }

    }
