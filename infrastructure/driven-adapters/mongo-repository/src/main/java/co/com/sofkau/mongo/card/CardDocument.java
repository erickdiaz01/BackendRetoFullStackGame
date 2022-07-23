package co.com.sofkau.mongo.card;

import co.com.sofkau.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Cards")
public class CardDocument {
    @Id
    private String cardId;
    private String nameOfCard;
    private String features;
    private String urlImage;
    private Integer power;
    //private Set<String> cards;

   /* public CardDocument(String cardId, String nameOfCard, String features, String urlImage, Integer power) {
        this.cardId = cardId;
        this.nameOfCard = nameOfCard;
        this.features = features;
        this.urlImage = urlImage;
        this.power = power;
    }*/
}
