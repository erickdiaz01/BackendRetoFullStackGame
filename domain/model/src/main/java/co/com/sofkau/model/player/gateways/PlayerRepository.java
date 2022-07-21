package co.com.sofkau.model.player.gateways;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerRepository {
    Mono <Player> save(Player player);
    Flux<Player> findAll();
    Mono<Player> findById(String playerId);
    Mono <Player> update(String playerId, Player player);
    Mono <Void> deleteById(String playerId);


}
