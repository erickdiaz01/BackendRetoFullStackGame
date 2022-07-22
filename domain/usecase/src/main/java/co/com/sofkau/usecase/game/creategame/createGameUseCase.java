package co.com.sofkau.usecase.game.creategame;


import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.board.createboard.CreateBoardUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class createGameUseCase {
    private final GameRepository gameRepository;
    private final CreateBoardUseCase createBoardUseCase;
    public Mono<Game> SaveGame(Game game){
        game.setBoard(createBoardUseCase.createBoard(game.getBoard()).toFuture().join());
        return gameRepository.save(game);
    }
}
