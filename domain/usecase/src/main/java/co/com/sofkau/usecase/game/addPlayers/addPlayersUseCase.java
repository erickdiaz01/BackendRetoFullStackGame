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
    public Mono<Game> savePlayer(String id , Player player){
        var game = findGameByIdUseCase.findGameById(id).toFuture().join();
        game.getPlayers().add(player);
        if (game.getPlayers().size()>=2){
            dealCardsUseCase.dealCards(id,game);
        }
        return gameRepository.addPlayerGame(id,game);
    }
}
