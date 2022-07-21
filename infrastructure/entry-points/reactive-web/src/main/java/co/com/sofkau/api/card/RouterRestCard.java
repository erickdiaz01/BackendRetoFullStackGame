package co.com.sofkau.api.card;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRestCard {
@Bean
public RouterFunction<ServerResponse> routerFunctionCard(HandlerCard handlerCard) {
    return route(GET("/api/card/listcards"), handlerCard::listCards)
    .andRoute(POST("/api/card/createcard"), handlerCard::createCard).andRoute(GET("/api/card/listcard/{id}"),handlerCard::findCardById)
            .andRoute(PUT("/api/card/updatecard/{id}"),handlerCard::updateCard)
            .andRoute(DELETE("api/card/deletecard/{id}"),handlerCard::deleteCardById);

    }
}
