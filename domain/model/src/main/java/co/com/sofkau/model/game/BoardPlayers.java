package co.com.sofkau.model.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import lombok.Data;

import java.util.Set;
@Data
public class BoardPlayers {

    private Set<Player> playersInGame;
    private Board board;
}
