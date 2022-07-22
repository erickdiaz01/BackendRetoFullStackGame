package co.com.sofkau.mongo.board;

import co.com.sofkau.model.board.CardInGame;
import co.com.sofkau.model.board.Round;
import co.com.sofkau.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@Document(collection = "Boards")
public class BoardDocument {
    @Id
    private String boardId;

    private Round round;
    private Map<String, CardInGame> cardsInGame;
    private Set<String> principalMallet;

    public BoardDocument(String boardId, Round round, Map<String, CardInGame> cardsInGame, Set<String> principalMallet) {
        this.boardId = boardId;
        this.round = round;
        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public BoardDocument(String boardId, Round round, Set<String> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame =new HashMap<>();
        this.round=round;
        this.principalMallet = principalMallet;
    }
}
