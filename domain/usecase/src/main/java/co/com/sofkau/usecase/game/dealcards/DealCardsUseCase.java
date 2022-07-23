package co.com.sofkau.usecase.game.dealcards;

import co.com.sofkau.model.board.CardInGame;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DealCardsUseCase {
    private final GameRepository gameRepository;

    public Mono<Game> dealCards(String gameId, Game game){

        game.getPlayers().stream().forEach(player -> {
            var barajaASortear = new ArrayList<Card>();
            barajaASortear.addAll(game.getBoard().getPrincipalMallet());
            Collections.shuffle(barajaASortear);
           var cardsPlayer=barajaASortear.stream().limit(5).map(card -> {
                        game.getBoard().getPrincipalMallet().remove(card);
                       return  new CardInGame(card);
                    }
            ).collect(Collectors.toSet());
            player.setCards(cardsPlayer);
        });
        return gameRepository.dealCards(gameId,game);
    }
}
