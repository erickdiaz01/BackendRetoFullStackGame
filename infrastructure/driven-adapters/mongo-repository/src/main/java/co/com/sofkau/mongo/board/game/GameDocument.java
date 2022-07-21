package co.com.sofkau.mongo.board.game;

import co.com.sofkau.model.board.Board;
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
    private Set<String> players;
    private String game;
}
