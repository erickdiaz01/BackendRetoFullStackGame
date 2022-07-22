package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class addPlayersUseCase {
    private final GameRepository gameRepository;
    public Mono<Game> savePlayer(String id , Game game){
        return gameRepository.addPlayerGame(id,game);
    }
}
