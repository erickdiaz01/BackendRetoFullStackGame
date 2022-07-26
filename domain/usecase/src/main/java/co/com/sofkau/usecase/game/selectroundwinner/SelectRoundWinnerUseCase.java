package co.com.sofkau.usecase.game.selectroundwinner;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.game.changeRound.ChangeRoundUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.verifyplayerlosed.VerifyPlayerLosedUseCase;
import co.com.sofkau.usecase.player.assigncardtoplayer.AssignCardToPlayerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SelectRoundWinnerUseCase {
 private final GameRepository gameRepository;
    private final AssignCardToPlayerUseCase assignCardToPlayerUseCase;
    private final FindGameByIdUseCase findGameByIdUseCase;
    private final VerifyPlayerLosedUseCase verifyPlayerLosedUseCase;
    private final ChangeRoundUseCase changeRoundUseCase;


    public Mono<Game> selectRoundWinner(String gameId){
       Game game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var winnerCard= game.getBoard().getCardsInGame()
                .stream().max(Comparator.comparing(cardInGame -> cardInGame.getCard().getPower())).get();

       var winnerPlayer = game.getPlayers().stream()
               .filter(player -> player.getPlayerId().equals(winnerCard.getPlayerId())).reduce((player, player2) -> player2).get();
        game.getBoard().getCardsInGame().forEach(cardInGame -> cardInGame.setPlayerId(winnerCard.getPlayerId()));
        winnerPlayer.getCards().addAll(game.getBoard().getCardsInGame());
        assignCardToPlayerUseCase.assignCardToPlayer(winnerPlayer.getPlayerId(),winnerPlayer);
        game.getBoard().getCardsInGame().clear();
        verifyPlayerLosedUseCase.verifyPlayerLosed(gameId,game);
        return gameRepository.selectRoudnWinner(gameId,game);
    }
}
