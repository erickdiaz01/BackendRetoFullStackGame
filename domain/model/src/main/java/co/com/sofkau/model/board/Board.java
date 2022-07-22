package co.com.sofkau.model.board;
import co.com.sofkau.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private String boardId;
    private Round round;
    private Map<String,CardInGame> cardsInGame;
    private Set<Card> principalMallet;
}
