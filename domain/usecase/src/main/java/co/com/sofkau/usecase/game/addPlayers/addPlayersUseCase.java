package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.game.dealcards.DealCardsUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class addPlayersUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;
    private final DealCardsUseCase dealCardsUseCase;
    public Mono<Game> savePlayer(String gameId , Player player){
        var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        game.getPlayers().add(player);
        if(game.getPlayers().size()>=5){
            dealCardsUseCase.dealCards(gameId,game);
        }
        return gameRepository.addPlayerGame(gameId,game);
    }
}
