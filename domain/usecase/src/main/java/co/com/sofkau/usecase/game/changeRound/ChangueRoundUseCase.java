package co.com.sofkau.usecase.game.changeRound;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.findGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ChangueRoundUseCase {
    private final GameRepository gameRepository;
    private final findGameByIdUseCase findgameByIdUseCase;
    public Mono<Game> changeRound(String gameId){
      var valor=  findgameByIdUseCase.findGameById(gameId).map(game -> game.getIdPlayer());
      return null;
    }

}
