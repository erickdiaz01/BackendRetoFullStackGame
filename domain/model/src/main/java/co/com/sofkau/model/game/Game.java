package co.com.sofkau.model.game;
import co.com.sofkau.model.board.Board;
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
    private Set<String> players;
    private String game;
}
