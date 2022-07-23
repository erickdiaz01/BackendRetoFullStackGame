package co.com.sofkau.usecase.game.verifyplayerlosed;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VerifyPlayerLosedUseCase {
    private final GameRepository gameRepository;

    public Mono<Game> verifyPlayerLosed(String gameId, Game game){
        game.getPlayers().stream().filter(player -> player.getCards().size()==0).map(player -> game.getPlayers().remove(player));
        if(game.getPlayers().size()==1){
            //TODO: ACTIVAR CASO DE USO GANADOR DEL JUEGO
        }else{
            //TODO: CAMBIAR DE RONDA
        }
        return gameRepository.playerLosed(gameId,game);
    }
}
