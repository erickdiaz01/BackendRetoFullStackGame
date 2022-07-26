package co.com.sofkau.usecase.game.betCard;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.selectCard.selectCardUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
public class betCardUseCase {
    private final GameRepository gameRepository;
    private final selectCardUseCase selectCardUseCase;
    private final FindGameByIdUseCase findGameByIdUseCase;

    public Mono<Game> betCardPlayer(String gameId , String playerId ,String cardId){
        var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var card = selectCardUseCase.selectCard(cardId,playerId,gameId).toFuture().join();
        card.setViewed(!card.isViewed());
        if(game.getBoard().getCardsInGame()==null){
            game.getBoard().setCardsInGame(new ArrayList<>());
        }

        game.getBoard().getCardsInGame().add(card);
     var playerOne=   game.getPlayers().stream().filter(player -> player.getPlayerId().equals(playerId))
             .reduce((player, playerTwo) -> playerTwo).orElseThrow();
     playerOne.getCards().remove(card);
        return gameRepository.betCardPlayer(gameId,game);
    }
}
