package co.com.sofkau.usecase.game.betCard;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.findGameByIdUseCase;
import co.com.sofkau.usecase.game.selectCard.selectCardUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class betCardUseCase {
    private final GameRepository gameRepository;
    private final selectCardUseCase selectCardUseCase;
    private final findGameByIdUseCase findGameByIdUseCase;

    public Mono<Game> betCardPlayer(String gameId , String playerId ,String cardId){
        var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var card = selectCardUseCase.selectCard(cardId,playerId,gameId).toFuture().join();
        card.setViewed(!card.isViewed());
        game.getBoard().getCardsInGame().put(playerId,card);
     var playerOne=   game.getPlayers().stream().filter(player -> player.getPlayerId().equals(playerId))
             .reduce((player, playerTwo) -> playerTwo).orElseThrow();
     playerOne.getCards().remove(card);
        return gameRepository.betCardPlayer(gameId,game);
    }
}
