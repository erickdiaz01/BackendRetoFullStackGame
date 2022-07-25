package co.com.sofkau.usecase.game.creategame;


import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.board.createboard.CreateBoardUseCase;
import co.com.sofkau.usecase.card.findallcards.FindAllCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;


@RequiredArgsConstructor
public class createGameUseCase {
    private final GameRepository gameRepository;
    private final CreateBoardUseCase createBoardUseCase;
    private final FindAllCardsUseCase findAllCardsUseCase;
    public Mono<Game> SaveGame(Game game){
        game.getBoard().setPrincipalMallet(findAllCardsUseCase
                .findAllCards()
                .collectList().toFuture()
                .join()
                .stream().collect(Collectors.toSet()));
        game.setBoard(createBoardUseCase.createBoard(game.getBoard()).toFuture().join());
        return gameRepository.save(game);
    }
}
