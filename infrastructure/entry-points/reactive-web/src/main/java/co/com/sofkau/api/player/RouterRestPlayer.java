package co.com.sofkau.api.player;

import co.com.sofkau.api.card.HandlerCard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestPlayer {


    @Bean
    public RouterFunction<ServerResponse> routerFunctionPlayer(HandlerPlayer handlerPlayer) {
        return route(GET("/api/player/listplayers"), handlerPlayer::findAllPlayers)
                .andRoute(POST("/api/player/createplayer"), handlerPlayer::createPlayer)
                .andRoute(GET("/api/card/listplayer/{id}"),handlerPlayer::findPlayerById)
                .andRoute(PUT("/api/player/updateplayer/{id}"),handlerPlayer::updatePlayer)
                .andRoute(DELETE("api/player/deleteplayer/{id}"),handlerPlayer::deletePlayerById);

    }

}
