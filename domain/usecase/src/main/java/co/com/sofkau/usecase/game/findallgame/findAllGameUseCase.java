package co.com.sofkau.usecase.game.findallgame;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
@RequiredArgsConstructor
public class findAllGameUseCase {
    private final GameRepository gameRepository;
    public Flux<Game> ListGame(){
        return gameRepository.findAll();
    }
}
