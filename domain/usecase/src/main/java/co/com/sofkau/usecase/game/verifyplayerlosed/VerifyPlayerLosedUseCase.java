package co.com.sofkau.usecase.game.verifyplayerlosed;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.board.ifnotwinnerchangeround.IfNotWinnerChangeRoundUseCase;
import co.com.sofkau.usecase.game.changeRound.ChangueRoundUseCase;
import co.com.sofkau.usecase.game.winnergame.WinnerGameUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VerifyPlayerLosedUseCase {
    private final GameRepository gameRepository;
    private final WinnerGameUseCase winnerGameUseCase;
    private final ChangueRoundUseCase changueRoundUseCase;
    public Mono<Game> verifyPlayerLosed(String gameId, Game game){
        game.getPlayers().stream().filter(player -> player.getCards().size()==0)
                .map(player -> game.getPlayers().remove(player));
        if(game.getPlayers().size()<2){
            winnerGameUseCase.winnerGame(gameId);
        }else{
            //TODO: CAMBIAR DE RONDA
         changueRoundUseCase.changeRoundGame(gameId);
        }
        return gameRepository.playerLosed(gameId,game);
    }
}
