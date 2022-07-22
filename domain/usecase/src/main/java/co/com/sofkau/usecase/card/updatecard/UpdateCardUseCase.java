package co.com.sofkau.usecase.card.updatecard;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCardUseCase {
    private final CardRepository cardRepository;
   public Mono<Card> updateCard(String cardId, Card card){
        return cardRepository.update(cardId,card);
    }
}
