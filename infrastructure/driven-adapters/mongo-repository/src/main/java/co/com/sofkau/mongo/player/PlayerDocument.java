package co.com.sofkau.mongo.player;



import co.com.sofkau.model.board.CardInGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Player")
public class PlayerDocument {
    @Id
    private String playerId;
    private String email;
    private Integer globalScore;
    private Integer localScore;
    private Set<CardInGame> cards;

    public PlayerDocument(String playerId,String email) {
        this.playerId = playerId;
        this.email= email;
        this.globalScore= 0;
        this.localScore = 0;
        this.cards= new HashSet<>();
    }

    public PlayerDocument(String email){
        this.email= email;
        this.globalScore= 0;
        this.localScore = 0;
        this.cards= new HashSet<>();
    }
}


