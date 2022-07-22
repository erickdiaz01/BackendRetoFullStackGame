package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class addPlayersUseCase {
    private GameRepository gameRepository;
    public Mono<Player> savePlayer(Player player){
        return gameRepository.addPlayer(player);
    }
}
