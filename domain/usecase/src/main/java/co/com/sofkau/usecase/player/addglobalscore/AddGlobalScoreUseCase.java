package co.com.sofkau.usecase.player.addglobalscore;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.player.findplayerbyid.FindPlayerByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddGlobalScoreUseCase {
    private final PlayerRepository playerRepository;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;

    public Mono<Player> addGlobalScore(String playerId){
        Player player = findPlayerByIdUseCase.findPlayerById(playerId).toFuture().join();
        if(player.getGlobalScore()==null){
            player.setGlobalScore(100);
        }else {
            player.setGlobalScore(player.getGlobalScore()+100);
        }
        return playerRepository.addGlobalScore(playerId,player);
    }
}
