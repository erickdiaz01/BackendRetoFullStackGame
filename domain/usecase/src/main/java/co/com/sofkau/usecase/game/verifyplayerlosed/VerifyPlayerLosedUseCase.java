package co.com.sofkau.usecase.game.verifyplayerlosed;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.board.ifnotwinnerchangeround.IfNotWinnerChangeRoundUseCase;
import co.com.sofkau.usecase.game.changeRound.ChangeRoundUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.winnergame.WinnerGameUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VerifyPlayerLosedUseCase {
    private final GameRepository gameRepository;
    private final WinnerGameUseCase winnerGameUseCase;
    private final ChangeRoundUseCase changeRoundUseCase;
    private final FindGameByIdUseCase findGameByIdUseCase;

    public Mono<Game> verifyPlayerLosed(String gameId){
        Game game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        game.getPlayers().stream().filter(player -> player.getCards().size()==0)
                .map(player -> game.getPlayers().remove(player));
        if(game.getPlayers().size()<2){


            winnerGameUseCase.winnerGame(gameId);
        }else{
            changeRoundUseCase.changeRoundGame(gameId);
        }
        return gameRepository.playerLosed(gameId,game);
    }
}
