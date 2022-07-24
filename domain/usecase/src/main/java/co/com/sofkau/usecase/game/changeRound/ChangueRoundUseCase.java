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
    public Mono<Game> changeRoundGame(String gameId){
           var Game= findgameByIdUseCase.findGameById(gameId).map(games -> {
            games.getRound().setNumber((games.getRound().getNumber()+1));
               System.out.println(games.toString());
            return games;
        }).toFuture().join();
      return gameRepository.changeRound(gameId,Game);
    }

}