package co.com.sofkau.api;

import co.com.sofkau.api.board.HandlerBoard;
import co.com.sofkau.api.card.HandlerCard;
import co.com.sofkau.api.game.HandlerGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerCard handlerCard, HandlerBoard handlerBoard, HandlerGame handlerGame) {
    return route(GET("/api/card/listcards"), handlerCard::listCards)
    .andRoute(POST("/api/card/createcard"), handlerCard::createCard)
            .andRoute(GET("/api/card/listcard/{id}"),handlerCard::findCardById)
            .andRoute(PUT("/api/card/updatecard/{id}"),handlerCard::updateCard)
            .andRoute(DELETE("api/card/deletecard/{id}"),handlerCard::deleteCardById)
            .andRoute(GET("/api/board/listboard/{id}"), handlerBoard::findBoardById)
            .andRoute(POST("/api/board/createboard"), handlerBoard::createBoard)
            .andRoute(GET("/api/game/listgame"),handlerGame::listGame)
            .andRoute(POST("/api/game/createGame"),handlerGame::createGame)
            .andRoute(GET("/api/game/{id}"),handlerGame::addPlayersGame);

    }
}
