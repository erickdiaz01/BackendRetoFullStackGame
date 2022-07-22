package co.com.sofkau.usecase.player.findallplayers;


import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllPlayersUseCase {
    private final PlayerRepository playerRepository;

    public Flux<Player> findAllPlayers(){
        return playerRepository.findAll();
    }
}
