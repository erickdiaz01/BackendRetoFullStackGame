package co.com.sofkau.model.board;
import co.com.sofkau.model.game.Round;
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
    private Round round;
    private Map<String,CardInGame> cardsInGame;
    private Set<String> principalMallet;

    public Board(String boardId, Round round, Map<String, CardInGame> cardsInGame, Set<String> principalMallet) {
        this.boardId = boardId;
        this.round = round;
        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public Board(String boardId, Round round, Set<String> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame =new HashMap<>();
        this.round=round;
        this.principalMallet = principalMallet;
    }
}
