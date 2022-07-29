package co.com.sofkau.model.game;
import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
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

    private Boolean begined;

    private LocalDateTime creation;

    public Game(Board board) {
        this.board = board;
        this.idPlayer="";
        this.begined=false;
        ZoneId zid = ZoneId.of("America/Bogota");
        this.creation= LocalDateTime.now(zid) ;
    }
   

    public Game(Board board, Set<Player> players) {
        this.board = board;
        this.players = players;
        this.begined=false;
        ZoneId zid = ZoneId.of("America/Bogota");
        this.creation= LocalDateTime.now(zid) ;
    }

    public Game(){
        this.board = new Board();
        this.players = new HashSet<>();
        this.round = 1;
        this.idPlayer = "";
        this.begined=false;
        ZoneId zid = ZoneId.of("America/Bogota");
        this.creation= LocalDateTime.now(zid) ;
    }
}
