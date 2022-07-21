package co.com.sofkau.model.board;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Round {
    private Integer number;
    private LocalDateTime time;

    public Integer getNumber() {
        return number;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
