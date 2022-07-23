package co.com.sofkau.model.board;

import co.com.sofkau.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardInGame {
    private Card card;
    private boolean viewed;

    public CardInGame(Card card) {
        this.card = card;
        this.viewed = true;
    }
}
