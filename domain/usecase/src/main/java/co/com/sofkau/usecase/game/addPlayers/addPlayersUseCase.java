package co.com.sofkau.usecase.game.addPlayers;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class addPlayersUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;
    public Mono<Game> savePlayer(String id , Player player){
        var game = findGameByIdUseCase.findGameById(id).toFuture().join();
        game.getPlayers().add(player);
        return gameRepository.addPlayerGame(id,game);
    }
}
