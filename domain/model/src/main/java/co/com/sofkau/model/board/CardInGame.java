package co.com.sofkau.model.board;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CardInGame {
    private String cardId;
    private boolean viewed;

    public String getCardId() {
        return cardId;
    }

    public Boolean getViewed() {
        return viewed;
    }
}
