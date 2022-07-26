package co.com.sofkau.usecase.game.betCard;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.board.changestateviewcards.ChangeStateViewCardsUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.selectCard.selectCardUseCase;
import co.com.sofkau.usecase.game.selectroundwinner.SelectRoundWinnerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RequiredArgsConstructor
public class betCardUseCase {
    private final GameRepository gameRepository;
    private final selectCardUseCase selectCardUseCase;
    private final FindGameByIdUseCase findGameByIdUseCase;
<<<<<<< HEAD


    /**Función de apuesta en el juego que reicbe los siguientes parametros:
     * @param gameId
     * @param playerId
     * @param cardId
     *
     * @return
     */
=======
    private final ChangeStateViewCardsUseCase changeStateViewCardsUseCase;
private  final SelectRoundWinnerUseCase selectRoundWinnerUseCase;
>>>>>>> main
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
     if(game.getBoard().getCardsInGame().size()==game.getPlayers().size()){
         System.out.println("hola");
         changeStateViewCardsUseCase.changeStateViewOfCards(game.getBoard().getBoardId(),game.getBoard());
     }
        return gameRepository.betCardPlayer(gameId,game);
    }
}
