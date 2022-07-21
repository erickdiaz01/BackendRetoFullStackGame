package co.com.sofkau.api.board;

import co.com.sofkau.api.card.HandlerCard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestBoard {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(HandlerBoard handlerBoard) {
        return route(GET("/api/board/listboard/{id}"), handlerBoard::findBoardById)
                .andRoute(POST("/api/board/createboard"), handlerBoard::createBoard)
                ;

    }
}