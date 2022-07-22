package co.com.sofkau.usecase.card.player.deleteplayer;


import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeletePlayerUseCase {
    private final PlayerRepository playerRepository;

    public Mono<Void> deletePlayerById(String playerId){
        return playerRepository.deleteById(playerId);
    }
}
