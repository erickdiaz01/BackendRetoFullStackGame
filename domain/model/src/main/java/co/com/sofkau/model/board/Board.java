package co.com.sofkau.model.board;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.objectvalues.CardInGame;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.function.Tuple2;

import java.util.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
public class Board {
    private String boardId;
    private List<CardInGame> cardsInGame;
    private Set<Card> principalMallet;

    public Board(String boardId, List<CardInGame> cardsInGame, Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public Board(String boardId, Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame = new ArrayList<>();
        this.principalMallet = principalMallet;
    }
}
