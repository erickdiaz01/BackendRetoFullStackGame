package co.com.sofkau.usecase.game.betCard;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class betCardUseCase {
    private final GameRepository gameRepository;
    /*
    public Mono<Game> betCardPlayer(String gameId , String playerId , Game game){
        game.getPlayers().stream()
                .filter(player->player.getPlayerId().equals(playerId))



        return gameRepository.betCardPlayer(gameId,playerId,game);
    }*/
}
