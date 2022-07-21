package co.com.sofkau.usecase.player.findplayerbyid;


import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindPlayerByIdUseCase {
    private final PlayerRepository playerRepository;
    public Mono<Player> findPlayerById(String playerId){
        return playerRepository.findById(playerId);
    }
}
