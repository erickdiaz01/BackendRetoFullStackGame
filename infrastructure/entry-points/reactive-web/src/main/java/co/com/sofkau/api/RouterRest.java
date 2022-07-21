package co.com.sofkau.api;

import co.com.sofkau.api.card.HandlerCard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerCard handlerCard) {
    return route(GET("/api/card/listcards"), handlerCard::listCards)
    .andRoute(POST("/api/card/createcard"), handlerCard::createCard);

    }
}
