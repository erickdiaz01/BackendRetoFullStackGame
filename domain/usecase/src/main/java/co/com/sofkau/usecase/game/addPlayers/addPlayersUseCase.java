package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Mono;

public class addPlayersUseCase {
    private GameRepository gameRepository;
    public Mono<Player> savePlayer(Player player){
        return gameRepository.addPlayer(player);
    }
}
