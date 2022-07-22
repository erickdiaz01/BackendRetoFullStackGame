package co.com.sofkau.model.player;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CardInGame {

    private String cardId;
    private Boolean isViewed;
    public String getCardId() {
        return cardId;
    }
    public Boolean getViewed() {
        return isViewed;
    }
}
