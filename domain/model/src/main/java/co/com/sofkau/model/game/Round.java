package co.com.sofkau.model.game;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Round {
    private Integer number;
    private String time;

    public Integer getNumber() {
        return number;
    }

    public String getTime() {
        return time;
    }
}
