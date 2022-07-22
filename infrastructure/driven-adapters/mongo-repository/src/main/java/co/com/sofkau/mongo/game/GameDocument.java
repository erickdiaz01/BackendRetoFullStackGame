package co.com.sofkau.mongo.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDocument {
    @Id
    private String id;
    private Board board;
    private Set<Player> players;
    private String idPlayer;

    public GameDocument(String id, Board board) {
        this.id = id;
        this.board = board;
        this.idPlayer="";
    }
}