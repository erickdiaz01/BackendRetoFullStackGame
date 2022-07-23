package co.com.sofkau.usecase.game.selectCard;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class selectCardUseCase {
    private final GameRepository gameRepository;
    public Mono<Game> selectCard(){
        return null;
    }
}

