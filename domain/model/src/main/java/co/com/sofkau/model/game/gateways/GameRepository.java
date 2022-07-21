package co.com.sofkau.model.game.gateways;

import co.com.sofkau.model.game.Game;
import reactor.core.publisher.Mono;

public interface GameRepository {
    Mono<Game> save(Game game);

}
