package co.com.sofkau.model.player;
import co.com.sofkau.model.objectvalues.CardInGame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Player {
    private String playerId;
    private String email;
    private Integer globalScore;
    private Integer localScore;
    private Set<CardInGame> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId.equals(player.playerId) && email.equals(player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, email);
    }

    public Player(String playerId, String email) {
        this.playerId = playerId;
        this.email= email;
        this.globalScore= 0;
        this.localScore = 0;
        this.cards= new HashSet<>();
    }

    public Player(String email){
        this.email= email;
        this.globalScore= 0;
        this.localScore = 0;
        this.cards= new HashSet<>();
    }


}
