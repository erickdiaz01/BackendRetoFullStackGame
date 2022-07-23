package co.com.sofkau.usecase.game.selectroundwinner;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.card.player.findplayerbyid.FindPlayerByIdUseCase;
import co.com.sofkau.usecase.player.assigncardtoplayer.AssignCardToPlayerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SelectRoundWinnerUseCase {
 private final GameRepository gameRepository;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;
    private final AssignCardToPlayerUseCase assignCardToPlayerUseCase;


    public Mono<Game> selectRoundWinner(String gameId, Game game){
        var winnerCard= game.getBoard().getCardsInGame().values().stream()
                .max(Comparator.comparing(o -> o.getCard().getPower())).orElseThrow();
       var winnerRoundId = game.getBoard().getCardsInGame().entrySet()
               .stream()
               .filter(stringCardInGameEntry ->
                       stringCardInGameEntry.getValue()==winnerCard
               ).map(Map.Entry::getKey)
               .reduce((s, s2) -> s+s2)
               .orElseThrow();

       var winnerPlayer = game.getPlayers().stream()
               .filter(player -> player.getPlayerId().equals(winnerRoundId)).collect(Collectors.toList()).get(0);
       winnerPlayer.getCards().addAll(game.getBoard().getCardsInGame().values());
       assignCardToPlayerUseCase.assignCardToPlayer(winnerPlayer.getPlayerId(),winnerPlayer);
       game.getBoard().getCardsInGame().clear();
        // TODO:  LLAMAR AL CASO DE USO DE CAMBIAR RONDA
        return gameRepository.selectRoudnWinner(gameId,game);
    }
}
