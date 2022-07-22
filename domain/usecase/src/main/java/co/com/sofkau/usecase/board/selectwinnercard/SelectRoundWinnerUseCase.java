package co.com.sofkau.usecase.board.selectwinnercard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.player.assigncardtoplayer.AssignCardToPlayerUseCase;
import co.com.sofkau.usecase.player.findplayerbyid.FindPlayerByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Map;

@RequiredArgsConstructor
public class SelectRoundWinnerUseCase {
    private final BoardRepository boardRepository;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;
    private final AssignCardToPlayerUseCase assignCardToPlayerUseCase;


    public Mono<Board> selectRoundWinner(String boardId, Board board){
        var winnerCard= board.getCardsInGame().values().stream().max(Comparator.comparing(o -> o.getCard().getPower())).orElseThrow();
       var winnerRoundId = board.getCardsInGame().entrySet()
               .stream()
               .filter(stringCardInGameEntry ->
                       stringCardInGameEntry.getValue()==winnerCard
               ).map(Map.Entry::getKey)
               .reduce((s, s2) -> s+s2)
               .orElseThrow();
       var winnerPlayer = findPlayerByIdUseCase.findPlayerById(winnerRoundId).toFuture().join();
       winnerPlayer.getCards().addAll(board.getCardsInGame().values());
       assignCardToPlayerUseCase.assignCardToPlayer(winnerPlayer.getPlayerId(),winnerPlayer);
       board.getCardsInGame().clear();
        return boardRepository.selectWinnerCard(boardId,board);
    }
}
