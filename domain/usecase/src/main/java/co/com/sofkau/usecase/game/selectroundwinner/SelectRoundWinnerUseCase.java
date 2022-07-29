package co.com.sofkau.usecase.game.selectroundwinner;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.usecase.board.changestateviewcards.ChangeStateViewCardsUseCase;
import co.com.sofkau.usecase.game.changeRound.ChangeRoundUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.verifyplayerlosed.VerifyPlayerLosedUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Caso que selecciona el ganador de la ronda con respecto a la tarjeta apostada
 */
@RequiredArgsConstructor
public class SelectRoundWinnerUseCase {
 private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;
    private final VerifyPlayerLosedUseCase verifyPlayerLosedUseCase;


    /**
     * Metodo que recibe por parametro el id del juego para buscarlo, comparar las tarjetas en juego que tiene
     * en el tablero y elegir la de maximo poder, esa tarjeta tiene un Id del jugador que la lanzo,
     * posteriormente se inyectan las tarjetas de todo el tablero en juego hacia el mazo del ganador
     * @param gameId {String}
     * @return
     */
    public Mono<Game> selectRoundWinner(String gameId){
       var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();

        var winnerCard= game
                .getBoard().getCardsInGame()

                .stream().max(Comparator.comparing(cardInGame -> cardInGame.getCard().getPower())).orElseThrow(() -> new RuntimeException("No hay carta"));

       var winnerPlayer = game.getPlayers().stream()
               .filter(player -> player.getPlayerId().equals(winnerCard.getPlayerId())).reduce((player, player2) -> player2).orElseThrow();
        game.getBoard().getCardsInGame().forEach(cardInGame -> cardInGame.setPlayerId(winnerCard.getPlayerId()));
        winnerPlayer.getCards().addAll(game.getBoard().getCardsInGame());
        game.getBoard().getCardsInGame().clear();
        return gameRepository.selectRoudnWinner(gameId,game);
    }
}
