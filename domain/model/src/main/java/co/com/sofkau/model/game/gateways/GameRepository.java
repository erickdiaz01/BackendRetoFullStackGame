package co.com.sofkau.model.game.gateways;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface GameRepository {
    Mono<Game> save(Game game);
    Flux<Game> findAll();
    Mono<Game> findById(String gameId);
    Mono<Game> addPlayerGame(String id , Game game);
    Mono<Player> Winner (String id);
    Mono<Long> countPlayers(String gameId,Game game);

    Mono<Game> dealCards(String gameId,Game game);

    Mono<Game> surrenderPlayer(String playerId, Game game, String gameId);
    /*
    Mono<Game> betCardPlayer(String gameId , String playerId , String cardId, Game game);*/
}
