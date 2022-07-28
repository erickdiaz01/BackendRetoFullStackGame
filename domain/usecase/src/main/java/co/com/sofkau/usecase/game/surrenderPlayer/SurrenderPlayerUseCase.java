package co.com.sofkau.usecase.game.surrenderPlayer;


import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;

import co.com.sofkau.usecase.player.findplayerbyid.FindPlayerByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
/**
 *Caso de uso que hace que el jugador permita retirarse del juego
 */
@RequiredArgsConstructor
public class SurrenderPlayerUseCase {

    private final GameRepository gameRepository;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;

    /**
     * Recibe el id del jugador para hacer la comparacion en el juego tambien pasado por parametros,
     * filtra el jugador con ese Id y le remueve las cartas que tenia y las vuelve a ingresar en el mazo
     * principal del tablero. Posteriormente lo remueve de la lista de jugadores del juego y persiste el juego
     * modificado
     * @param playerId {String}
     * @param game {Game}
     * @param gameId {String}
     * @return
     */

    public Mono<Game> surrenderPlayer(String playerId, Game game, String gameId) {

        game.getPlayers().stream().filter(player -> player.getPlayerId().equals(playerId))
                        .forEach(player->{
                            game.getBoard().getPrincipalMallet().addAll(player.getCards()
                            .stream().map(CardInGame::getCard).collect(Collectors.toList()));
                            player.getCards().clear();
                        });


        game.getPlayers().remove(findPlayerByIdUseCase.findPlayerById(playerId).toFuture().join());
        return gameRepository.surrenderPlayer(playerId,game, gameId);


    }
}
