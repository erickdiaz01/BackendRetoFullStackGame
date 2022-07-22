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
}
