package co.com.sofkau.usecase.game.changeRound;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Clase que contiene el metodo para realizar el cambio de ronda del juego cada que sea necesaria
 * la verificacion de cambiar la ronda, este metodo se inyecta cuando se muestran todads las cartas del tablero y
 * se elije un ganador de la ronda y no hay un ganador del juego general
 */
@RequiredArgsConstructor
public class ChangeRoundUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findgameByIdUseCase;

    /**
     * Metodo que recibe por parametros el id del juego a cambiarle la ronda una vez se necesite,
     * con el id se busca en el repositorio el juego a cambiar la ronda, se le adiciona una unidad
     * al atributo de la ronda y posteriormente se envia al repositorio para persistir la informacion del
     * juego
     * @param gameId {String}
     * @return {Mono<Game>}
     */
    public Mono<Game> changeRoundGame(String gameId){
           var Game= findgameByIdUseCase.findGameById(gameId).map(games -> {
               games.setRound((games.getRound()+1));
            return games;
        }).toFuture().join();
      return gameRepository.changeRound(gameId,Game);
    }

}
