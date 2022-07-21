package co.com.sofkau.model.carta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Carta {
    private String cardId;
    private String nameOfCard;
    private String features;
    private String urlImage;
    private Integer power;
}
