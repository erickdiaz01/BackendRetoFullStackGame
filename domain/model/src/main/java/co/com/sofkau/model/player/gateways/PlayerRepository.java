package co.com.sofkau.model.player.gateways;

import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Mono;

public interface PlayerRepository {
    Mono <Player> save(Player player);
    Mono <Player> findById(String playerId);
    Mono <Player> update(String playerId, Player player);
    Mono <Player> deleteById(String playerId);


}
