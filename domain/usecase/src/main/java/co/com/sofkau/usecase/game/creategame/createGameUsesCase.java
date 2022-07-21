package co.com.sofkau.usecase.game.creategame;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class createGameUsesCase {
    private final GameRepository gameRepository;
    public Mono<Game> SaveGame(Game game){
        return gameRepository.save(game);
    }
}
