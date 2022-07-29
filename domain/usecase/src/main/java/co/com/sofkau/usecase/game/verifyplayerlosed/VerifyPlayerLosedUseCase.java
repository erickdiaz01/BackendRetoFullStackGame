package co.com.sofkau.usecase.game.verifyplayerlosed;

import java.util.stream.Collectors;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.game.changeRound.ChangeRoundUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.winnergame.WinnerGameUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;


/**
 * Caso de uso que verifica si hay algun eliminado cada que se destapan las cartas del tablero
 */
@RequiredArgsConstructor
public class VerifyPlayerLosedUseCase {
    private final GameRepository gameRepository;
    private final WinnerGameUseCase winnerGameUseCase;
    private final ChangeRoundUseCase changeRoundUseCase;
    private  final FindGameByIdUseCase findGameByIdUseCase;

    /**
     * Metodo que filtra los jugadores que no tienen cartas en su mazo, asi los remueve de la lista.
     * Si en la lista de jugadores queda 1 solo jugador, este jugador es el ganador y se llama el caso de uso
     * de declarar ganador a un jugador, y si no, cambia la ronda para seguir jugando
     *
     * @param gameId
     * @param game
     * @return
     */
    public Mono<Game> verifyPlayerLosed(String gameId, Game game){
       var data = game.getPlayers().stream().filter(player -> player.getCards().isEmpty()).collect(Collectors.toSet());
       game.getPlayers().removeAll(data);
        if(game.getPlayers().size()<2){
            System.out.println("hola");
            winnerGameUseCase.winnerGame(gameId,game);
        }else{
            changeRoundUseCase.changeRoundGame(gameId);
        }
        return gameRepository.playerLosed(gameId,game);
    }
}
