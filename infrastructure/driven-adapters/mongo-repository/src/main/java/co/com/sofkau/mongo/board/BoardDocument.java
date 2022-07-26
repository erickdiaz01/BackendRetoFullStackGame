package co.com.sofkau.mongo.board;

import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.model.card.Card;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.util.function.Tuple2;

import java.util.*;

@Data
@NoArgsConstructor
@Document(collection = "Boards")
public class BoardDocument {
    @Id
    private String boardId;

    private List<CardInGame> cardsInGame;
    private Set<Card> principalMallet;

    public BoardDocument(String boardId,  List<CardInGame> cardsInGame, Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame = cardsInGame;
        this.principalMallet = principalMallet;
    }

    public BoardDocument(String boardId,  Set<Card> principalMallet) {
        this.boardId = boardId;
        this.cardsInGame =new ArrayList<>();

        this.principalMallet = principalMallet;
    }
}
