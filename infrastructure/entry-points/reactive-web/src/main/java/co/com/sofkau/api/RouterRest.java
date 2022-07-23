package co.com.sofkau.api;

import co.com.sofkau.api.board.HandlerBoard;
import co.com.sofkau.api.card.HandlerCard;
import co.com.sofkau.api.game.HandlerGame;
import co.com.sofkau.api.player.HandlerPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerCard handlerCard, HandlerBoard handlerBoard, HandlerGame handlerGame, HandlerPlayer handlerPlayer) {
    return route(GET("/api/card/listcards"), handlerCard::listCards)
    .andRoute(POST("/api/card/createcard"), handlerCard::createCard)
            .andRoute(GET("/api/card/listcard/{id}"),handlerCard::findCardById)
            .andRoute(PUT("/api/card/updatecard/{id}"),handlerCard::updateCard)
            .andRoute(DELETE("api/card/deletecard/{id}"),handlerCard::deleteCardById)
            .andRoute(GET("/api/board/listboard/{id}"), handlerBoard::findBoardById)
            .andRoute(POST("/api/board/createboard"), handlerBoard::createBoard)
            .andRoute(POST("/api/board/changeviewcard/{id}"),handlerBoard::changeStateViewCards)
            .andRoute(GET("/api/game/listgame"),handlerGame::listGame)
            .andRoute(POST("/api/game/createGame"),handlerGame::createGame)
            .andRoute(PUT("/api/game/{id}"),handlerGame::addPlayersGame)
            .andRoute(POST("/api/game/dealcards/{id}"),handlerGame::dealCards)
            .andRoute(POST("/api/game/verifyplayerslosed/{id}"),handlerGame::verifyPlayersLosed)
            .andRoute(GET("/api/game/countplayers/{id}"),handlerGame::countPlayers)
            .andRoute(POST("/api/game/{gameId}/player/{playerId}"),handlerGame::surrenderPlayer)
            .andRoute(GET("/api/game/{gameId}/selectcard/{playerId}/card/{cardId}"),handlerGame::selectCard)
            .andRoute(POST("/api/game/{gameId}/betcard/{playerId}/card/{cardId}"),handlerGame::betCardPlayer)
            .andRoute(POST("/api/game/winnergame/{id}"),handlerGame::winnerGame)
            .andRoute(POST("/api/game/selectroundwinner/{id}"),handlerGame::selectRoundWinner)
            .andRoute(POST("/api/player/createplayer"), handlerPlayer::createPlayer)
            .andRoute(GET("/api/player/listplayer/{id}"),handlerPlayer::findPlayerById)
            .andRoute(PUT("/api/player/updateplayer/{id}"),handlerPlayer::updatePlayer)
            .andRoute(DELETE("api/player/deleteplayer/{id}"),handlerPlayer::deletePlayerById)
            .andRoute(POST("api/player/assigncards/{id}"),handlerPlayer::assignCardToPlayer);
    }
}
