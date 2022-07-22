package co.com.sofkau.model.game;
import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private String id;
    private Board board;
    private Set<Player> players;
    private String idPlayer;
    private Round round;

    public Game(Board board) {
        this.board = board;
        this.idPlayer="";
    }
}
