package co.com.sofkau.model.card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String cardId;
    private String nameOfCard;
    private String features;
    private String urlImage;
    private Integer power;
    /*
    public Card(String cardId, String nameOfCard, String features, String urlImage, Integer power) {
        this.cardId = cardId;
        this.nameOfCard = nameOfCard;
        this.features = features;
        this.urlImage = urlImage;
        this.power = power;
    }*/
}
