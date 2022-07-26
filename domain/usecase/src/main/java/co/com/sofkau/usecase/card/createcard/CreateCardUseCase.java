package co.com.sofkau.usecase.card.createcard;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCardUseCase {
    private final CardRepository cardRepository;
   public  Mono<Card> saveCard(Card card) {
        return cardRepository.save(card);
    }


}
