package co.com.sofkau.usecase.game.assignDeck;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.util.Collections;

@RequiredArgsConstructor
public class assingDeckUseCase {
    private final GameRepository gameRepository;
    private final CardRepository cardRepository;

    /*public Mono<Card> assingDeck(){
        return cardRepository.findAll().collectList().map(cards->{
            Collections.shuffle(cards);
            return cards;
        }).map(cards -> cards.subList(0, 5))
    }*/
}

