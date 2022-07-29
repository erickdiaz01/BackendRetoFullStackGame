package co.com.sofkau.usecase.player.playerRanking;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RankingPlayerUseCase {
    private final PlayerRepository playerRepository;
    public Flux<Player> rankinPlayer(){
        var player = playerRepository.findAll()
                .collectList().toFuture().join();
        var lista=   player.stream()
                .sorted((o1, o2) -> o2.getGlobalScore().compareTo(o1.getGlobalScore()))
                .collect(Collectors.toList()).subList(0,3);
        return playerRepository.rankingPlayer(lista);
    }
}
