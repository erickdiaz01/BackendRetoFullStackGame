package co.com.sofkau.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
