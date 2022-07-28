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

/**
 * Clase que contiene el metodo para persistir la reparticion de cartas
 * desde el tablero hacia los jugadores
 */
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

    private final ChangeStateViewCardsUseCase changeStateViewCardsUseCase;
    private  final SelectRoundWinnerUseCase selectRoundWinnerUseCase;


    /**
     *Metodo que recibe por parametros el id del juego, el id del jugador que apuesta la carta y el
     * id de la carta que se va a apostar, con el Id del juego se recupera el juego a partir del respositorio de
     * esta entidad, posteriormente se llama a otro caso de uso de seleccionar la carta a apostar del mazo del
     * jugador, ya con la carta y el juego, se realiza el tratamiento para que el tablero obtenga la carta
     * del jugador, y se inyecta al tablero removiendola del mazo del jugador, esta carta se apuesta con la
     * cara oculta
     * @param gameId {String}
     * @param playerId {String}
     * @param cardId {String}
     * @return {Mono<Game>}
     */

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
         changeStateViewCardsUseCase.changeStateViewOfCards(game.getBoard().getBoardId(),game.getBoard());
     }
        return gameRepository.betCardPlayer(gameId,game);
    }
}
