package co.com.sofkau.model.player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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
    private Set<String> cards;

    public Player(String playerId,String email) {
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