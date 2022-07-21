package co.com.sofkau.model.game.gateways;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Mono;

public interface GameRepository {
    Mono<Game> save(Game game);

    Mono<Player> addPlayer(Player player);

    Mono<Player> Winner (String id);

}
