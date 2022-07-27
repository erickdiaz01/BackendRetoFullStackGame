package co.com.sofkau.mongo.player;



import co.com.sofkau.model.objectvalues.CardInGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
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

    public PlayerDocument(String playerId, String email, Integer globalScore, Integer localScore) {
        this.playerId = playerId;
        this.email = email;
        this.globalScore = globalScore;
        this.localScore = localScore;
      this.cards=new HashSet<>();
    }

    public PlayerDocument(String playerId, String email) {
        this.playerId = playerId;
        this.email= email;
        this.globalScore= 0;
        this.localScore = 0;
        this.cards= new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerDocument)) return false;
        PlayerDocument that = (PlayerDocument) o;
        return playerId.equals(that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    public PlayerDocument(String email){
        this.email= email;
        this.globalScore= 0;
        this.localScore = 0;
        this.cards= new HashSet<>();
    }
}


