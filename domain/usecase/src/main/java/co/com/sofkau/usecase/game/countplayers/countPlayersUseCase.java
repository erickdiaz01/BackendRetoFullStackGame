package co.com.sofkau.usecase.game.countplayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Caso de uso que realiza el conteo de la lista de jugadores que estan en el juego
 */
@RequiredArgsConstructor
public class countPlayersUseCase {
    private final GameRepository gameRepository;

    /**
     * Metodo que envia al adapter el id del juego y el juego en si a contabilizar la lista de sus jugadores
     * @param gameId {String}
     * @param game {Game}
     * @return {Mono<Game>}
     */

    public Mono<Long> countPlayers(String gameId, Game game){
        return gameRepository.countPlayers(gameId,game);
    }
}
