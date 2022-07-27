package co.com.sofkau.usecase.game.selectCard;

import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

/**
 * Caso de uso que selecciona la carta del mazo del jugador y la retorna
 */
@RequiredArgsConstructor
public class selectCardUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;

    /**
     * Metodo que selecciona la carta del mazo del jugador a partir del Id pasado por parametros,
     * tambien recibe el Id del jugador para remover esa tarjeta y el id del juego en donde esta alojado
     * el jugador en la lista de jugadores
     * @param cardId
     * @param playerId
     * @param gameId
     * @return
     */
    public Mono<CardInGame> selectCard (String cardId , String playerId,String gameId){
          var game=  findGameByIdUseCase.findGameById(gameId).toFuture().join();
          var card= game.getPlayers().stream()
                  .filter(player -> player.getPlayerId().equals(playerId))
                  .flatMap(player -> player.getCards().stream())
                  .filter(cardInGames -> cardInGames.getCard().getCardId().equals(cardId))
                  .collect(Collectors.toList()).stream().findFirst().orElseThrow();


        return gameRepository.selectCard(card);
    }
}
