package co.com.sofkau.usecase.game.betCard;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.selectCard.selectCardUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@RequiredArgsConstructor
public class betCardUseCase {
    private final GameRepository gameRepository;
    private final selectCardUseCase selectCardUseCase;
    private final FindGameByIdUseCase findGameByIdUseCase;


    /**Función de apuesta en el juego que reicbe los siguientes parametros:
     * @param gameId
     * @param playerId
     * @param cardId
     *
     * @return
     */
    public Mono<Game> betCardPlayer(String gameId , String playerId ,String cardId){
        var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var card = selectCardUseCase.selectCard(cardId,playerId,gameId).toFuture().join();
        card.setViewed(!card.isViewed());
        if(game.getBoard().getCardsInGame()==null){
            game.getBoard().setCardsInGame(new HashMap<>());
        }
        game.getBoard().getCardsInGame().put(playerId,card);
     var playerOne=   game.getPlayers().stream().filter(player -> player.getPlayerId().equals(playerId))
             .reduce((player, playerTwo) -> playerTwo).orElseThrow();
     playerOne.getCards().remove(card);
        return gameRepository.betCardPlayer(gameId,game);
    }
}
