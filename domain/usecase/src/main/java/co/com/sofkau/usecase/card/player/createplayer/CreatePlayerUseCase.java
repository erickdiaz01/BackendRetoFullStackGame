package co.com.sofkau.usecase.card.player.createplayer;


import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatePlayerUseCase {
    private final PlayerRepository playerRepository;
    public Mono<Player> createPlayer(Player player) {
        return playerRepository.save(player);
    }
}
