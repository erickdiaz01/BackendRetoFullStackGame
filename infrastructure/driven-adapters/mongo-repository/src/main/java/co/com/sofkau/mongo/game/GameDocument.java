package co.com.sofkau.mongo.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.game.Round;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@Document(collection = "Game")
public class GameDocument {
    @Id
    private String id;
    private Board board;
    private Set<Player> players;
    private String idPlayer;
    private Round round;

    public GameDocument(String id, Board board) {
        this.id=id;
        this.board = board;
        this.idPlayer="";
    }

    public GameDocument(String id, Board board, Set<Player> players) {
        this.id=id;
        this.board = board;
        this.players = players;
        this.idPlayer="";
    }

    public GameDocument(String id, Board board, Set<Player> players, String idPlayer, Round round) {
        this.id = id;
        this.board = board;
        this.players = players;
        this.idPlayer = idPlayer;
        this.round = round;
    }
}