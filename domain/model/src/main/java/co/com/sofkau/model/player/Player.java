package co.com.sofkau.model.player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String playerId;
    private Set<String> cardInGame;
    private String globalScore;
    private String localScore;

}
