package co.com.sofkau.model.game;
import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Game {
    private String id;
    private Board board;
    private Set<Player> players;
    private String idPlayer;
    private Integer round;

    public Game(Board board) {
        this.board = board;
        this.idPlayer="";
    }
    public Game(){
        this.board=new Board();
        this.idPlayer="";
        this.players=new HashSet<>();
        this.round=1;
    }

    public Game(Board board, Set<Player> players) {
        this.board = board;
        this.players = players;
    }
}
