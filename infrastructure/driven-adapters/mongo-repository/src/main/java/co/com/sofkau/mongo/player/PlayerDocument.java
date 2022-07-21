package co.com.sofkau.mongo.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Player")
public class PlayerDocument {
    @Id
    private String playerId;
    private Set<String> cardInGame;
    private String globalScore;
    private String localScore;
}
