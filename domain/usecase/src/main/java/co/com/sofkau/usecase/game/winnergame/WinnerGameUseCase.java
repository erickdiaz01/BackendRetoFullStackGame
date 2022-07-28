package co.com.sofkau.usecase.game.winnergame;

import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.game.BoardPlayers;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.player.addglobalscore.AddGlobalScoreUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Caso de uso que le asigna el ganador a un juego
 */
@RequiredArgsConstructor
public class WinnerGameUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;

    private final AddGlobalScoreUseCase addGlobalScoreUseCase;

    /**
     * Metodo que recibe por parametros el id del juego a inyectar la informacion del jugador
     * ganador en el IdPlayer, posteriormente se llama el caso de uso de adicionar un score al global score del jugador
     * y se persiste esta informacion del juego
     * @param gameId
     * @return
     */
    public Mono<Game> winnerGame(String gameId){
        Game game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var winner= game.getPlayers().stream().distinct().collect(Collectors.toList()).stream().reduce((player, player2) -> player2).orElseThrow();
        game.setIdPlayer(winner.getPlayerId());
        addGlobalScoreUseCase.addGlobalScore(winner.getPlayerId());
        return gameRepository.winnerGame(gameId,game);
    }
}
