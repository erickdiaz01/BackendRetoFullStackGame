package co.com.sofkau.usecase.game.findbyid;


import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class findGameByIdUseCase {
    private final GameRepository gameRepository;

    public Mono<Game> findGameById(String gameId){
        return  gameRepository.findById(gameId);
    }
}
