package co.com.sofkau.usecase.player.createplayer;


import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatePlayerUserCase {
    private final PlayerRepository playerRepository;
    public Mono<Player> savePlayer(Player player) {
        return playerRepository.save(player);
    }
}
