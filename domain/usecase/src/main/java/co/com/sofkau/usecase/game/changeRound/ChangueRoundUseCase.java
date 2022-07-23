package co.com.sofkau.usecase.game.changeRound;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ChangueRoundUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findgameByIdUseCase;
    public Mono<Game> changeRound(String gameId){
      return findgameByIdUseCase.findGameById(gameId).map(game -> {
          Integer get= (game.getRound().getNumber()+1);
          game.getRound().setNumber(get);
          System.out.println(get);
          return game;
      });
    }

}
