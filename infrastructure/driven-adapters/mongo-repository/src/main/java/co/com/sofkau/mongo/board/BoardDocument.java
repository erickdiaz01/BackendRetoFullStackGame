package co.com.sofkau.mongo.board;

import co.com.sofkau.model.board.CardInGame;
import co.com.sofkau.model.board.Round;
import co.com.sofkau.model.carta.Carta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Boards")
public class BoardDocument {
    @Id
    private String boardId;

    private Round round;
    private Map<String, CardInGame> cardsInGame;
    private Set<Carta> principalMallet;
}
