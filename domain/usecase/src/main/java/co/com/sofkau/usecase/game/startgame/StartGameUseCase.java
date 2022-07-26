package co.com.sofkau.usecase.game.startgame;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


import java.util.Set;


@RequiredArgsConstructor
public class StartGameUseCase {

    private final GameRepository gameRepository;

    public Mono<Game> startGame(String gameId, Set<Player> players, Board board){
        return gameRepository.findById(gameId)
                .map(game ->{
                    game.setPlayers(players);
                    game.setBoard(board);
                    return game;
                })
                .flatMap(gameRepository::save);
    }
}
