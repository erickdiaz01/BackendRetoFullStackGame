package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.game.dealcards.DealCardsUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.startgame.StartGameUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase que contiene el metodo para el uso de caso para adicionar jugadores al juego creado,
 * a medida que vayan ingresando se iran persistiendo en el juego con su usuario de logueo
 */
@RequiredArgsConstructor
public class addPlayersUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;

    private final StartGameUseCase startGameUseCase;

    private final DealCardsUseCase dealCardsUseCase;



    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
    /**
     * Metodo que recibe por parametros el id del juego a modificar y el Player a adicionar
     * al juego, retona un Mono del tipo game modificado
     * @param gameId {String}
     * @param player {Mono<Player>}
     * @return
     */
    public Mono<Game> savePlayer(String gameId , Player player)  {
        var game = findGameByIdUseCase.findGameById(gameId).toFuture().join();

        game.getPlayers().add(player);
        return gameRepository.addPlayerGame(gameId,game);
    }
}
