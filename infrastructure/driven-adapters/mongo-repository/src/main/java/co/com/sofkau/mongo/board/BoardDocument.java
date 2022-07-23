package co.com.sofkau.mongo.board;

import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.model.card.Card;
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

    private Map<String, CardInGame> cardsInGame;
    private Set<Card> principalMallet;

    public BoardDocument(String boardId,  Map<String, CardInGame> cardsInGame, Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public BoardDocument(String boardId,  Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame =new HashMap<>();

        this.principalMallet = principalMallet;
    }
}
