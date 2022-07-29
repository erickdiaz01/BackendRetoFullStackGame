package co.com.sofkau.usecase.game.startgame;


import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.dealcards.DealCardsUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;






@RequiredArgsConstructor
public class StartGameUseCase {

    private final GameRepository gameRepository;
    private final DealCardsUseCase dealCardsUseCase;
    public Mono<Game> startGame(String gameId,Game game){
        game.setBegined(true);
       dealCardsUseCase.dealCards(gameId,game);
        return gameRepository.startGame(gameId,game);
    }
}
