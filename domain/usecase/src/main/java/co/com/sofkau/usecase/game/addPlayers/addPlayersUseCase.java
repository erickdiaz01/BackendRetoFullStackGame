package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.game.dealcards.DealCardsUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Clase que contiene el metodo para el uso de caso para adicionar jugadores al juego creado,
 * a medida que vayan ingresando se iran persistiendo en el juego con su usuario de logueo
 */
@RequiredArgsConstructor
public class addPlayersUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;
<<<<<<< HEAD


    /**
     * función de tipo Mono que guarda un jugador en el juego recibiendo por parametro el
     * @param id
     * @param player
     * se crea el juego de tipo Game a la cual se le añade el jugador recibido por parámetro
     * @return el repositorio
     */
    public Mono<Game> savePlayer(String id , Player player){
        var game = findGameByIdUseCase.findGameById(id).toFuture().join();
=======
    private final DealCardsUseCase dealCardsUseCase;

    /**
     * Metodo que recibe por parametros el id del juego a modificar y el Player a adicionar
     * al juego, retona un Mono del tipo game modificado
     * @param gameId {String}
     * @param player {Mono<Player>}
     * @return
     */
    public Mono<Game> savePlayer(String gameId , Player player){
        var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
>>>>>>> main
        game.getPlayers().add(player);
        if(game.getPlayers().size()>=2){
            dealCardsUseCase.dealCards(gameId,game);
        }
        return gameRepository.addPlayerGame(gameId,game);
    }
}
