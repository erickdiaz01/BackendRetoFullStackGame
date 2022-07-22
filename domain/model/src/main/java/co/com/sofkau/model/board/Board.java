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
    private Map<String,CardInGame> cardsInGame;
    private Set<String> principalMallet;

    public Board(String boardId, Map<String, CardInGame> cardsInGame, Set<String> principalMallet) {
        this.boardId = boardId;

        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public Board(String boardId, Set<String> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame =new HashMap<>();

        this.principalMallet = principalMallet;
    }
}
