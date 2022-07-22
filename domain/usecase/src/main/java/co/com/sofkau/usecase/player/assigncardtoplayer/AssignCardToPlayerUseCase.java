package co.com.sofkau.usecase.player.assigncardtoplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AssignCardToPlayerUseCase {

    private final PlayerRepository playerRepository;

    public Mono<Player> assignCardToPlayer(String playerId,Player player){
        return playerRepository.assignCardToPlayer(playerId,player);

    }

}
