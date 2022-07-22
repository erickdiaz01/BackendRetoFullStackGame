package co.com.sofkau.usecase.card.findallcards;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCardsUseCase {
    private final CardRepository cardRepository;

    public Flux<Card> findAllCards(){
        return cardRepository.findAll();
    }
}
