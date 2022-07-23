package co.com.sofkau.usecase.game.dealcards;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
public class DealCardsUseCase {
    private GameRepository gameRepository;

    public Mono<Game> dealCards(String gameId, Game game){
        var barajaSorteada = Arrays.asList(game.getBoard().getPrincipalMallet().toArray());
        Collections.shuffle(barajaSorteada);

        return gameRepository.dealCards(gameId,game);
    }
}
