package co.com.sofkau.model.board;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.objectvalues.CardInGame;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
public class Board {
    private String boardId;
    private Map<String, CardInGame> cardsInGame;
    private Set<Card> principalMallet;

    public Board(String boardId, Map<String, CardInGame> cardsInGame, Set<Card> principalMallet) {
        this.boardId = boardId;

        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public Board(String boardId, Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame =new HashMap<>();
        this.principalMallet = principalMallet;
    }
}
