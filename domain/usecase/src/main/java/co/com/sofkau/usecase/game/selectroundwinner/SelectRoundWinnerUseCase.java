package co.com.sofkau.usecase.game.selectroundwinner;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.card.player.findplayerbyid.FindPlayerByIdUseCase;
import co.com.sofkau.usecase.game.changeRound.ChangueRoundUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
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
    private final ChangueRoundUseCase changueRoundUseCase;


    public Mono<Game> selectRoundWinner(String gameId){
Game game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        var winnerCard= game.getBoard().getCardsInGame().values().stream()
                .max(Comparator.comparing(o -> o.getCard().getPower())).orElseThrow();
        System.out.println(winnerCard);
       var winnerRoundId = game.getBoard().getCardsInGame().entrySet()
               .stream()
               .filter(stringCardInGameEntry ->
                       stringCardInGameEntry.getValue()==winnerCard
               ).map(Map.Entry::getKey)
               .reduce((s, s2) -> s+s2)
               .orElseThrow();
        System.out.println(winnerRoundId);
       var winnerPlayer = game.getPlayers().stream()
               .filter(player -> player.getPlayerId().equals(winnerRoundId)).collect(Collectors.toList()).get(0);
        winnerPlayer.getCards().addAll(game.getBoard().getCardsInGame().values());
        assignCardToPlayerUseCase.assignCardToPlayer(winnerPlayer.getPlayerId(),winnerPlayer);
        game.getBoard().getCardsInGame().clear();
        //changueRoundUseCase.changeRoundGame(gameId);
        return gameRepository.selectRoudnWinner(gameId,game);
    }
}
