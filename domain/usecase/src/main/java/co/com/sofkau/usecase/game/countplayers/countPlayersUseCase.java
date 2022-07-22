package co.com.sofkau.usecase.game.countplayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class countPlayersUseCase {
    private final GameRepository gameRepository;

    public Mono<Long> countPlayers(String gameId, Game game){
        return gameRepository.countPlayers(gameId,game);
    }
}
