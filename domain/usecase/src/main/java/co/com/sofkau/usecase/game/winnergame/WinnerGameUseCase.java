package co.com.sofkau.usecase.game.winnergame;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class WinnerGameUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;

    public Mono<Game> winnerGame(String gameId){
         Game game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var winner= game.getPlayers().stream().findFirst().get();
        game.setIdPlayer(winner.getPlayerId());
        return gameRepository.winnerGame(gameId,game);
    }
}
