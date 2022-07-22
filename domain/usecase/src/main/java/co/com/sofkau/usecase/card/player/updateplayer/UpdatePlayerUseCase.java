package co.com.sofkau.usecase.card.player.updateplayer;



import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdatePlayerUseCase {
    private final PlayerRepository playerRepository;
    public Mono<Player> updatePlayer(String playerId, Player player){
        return playerRepository.update(playerId,player);
    }
}
