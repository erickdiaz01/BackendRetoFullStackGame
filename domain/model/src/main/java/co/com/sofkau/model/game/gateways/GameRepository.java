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
    Mono<Game> addPlayerGame(String id , Game game);

    Flux<Card> assingDeck(Set<Card> card);
    Mono<Player> Winner (String id);

}
