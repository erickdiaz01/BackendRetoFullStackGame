package co.com.sofkau.usecase.player.assigncardtoplayer.surrenderplayer;


import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SurrenderPlayerUseCase {
    private final PlayerRepository playerRepository;

    public Mono<Player> surrenderPlayer(String playerId, Player player) {
        return playerRepository.surrenderPlayer(playerId,player);
    }

}
