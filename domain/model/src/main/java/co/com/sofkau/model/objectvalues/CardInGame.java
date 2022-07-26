package co.com.sofkau.model.objectvalues;

import co.com.sofkau.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardInGame {
    private Card card;
    private String playerId;
    private boolean viewed;

    public CardInGame(String playerId,Card card) {
        this.card = card;
        this.playerId=playerId;
        this.viewed = true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardInGame)) return false;
        CardInGame that = (CardInGame) o;
        return card.equals(that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card);
    }
}
