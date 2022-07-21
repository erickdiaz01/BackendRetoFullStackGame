package co.com.sofkau.model.carta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Carta {
    private String cardId;
    private String nameOfCard;
    private String features;
    private String urlImage;
    private Integer power;
}
