package co.com.sofkau.usecase.card.findcardbyid;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindCardByIdUseCase {
    private final CardRepository cardRepository;
    public Mono<Card> findCardById(String idCard){
        return cardRepository.findById(idCard);
    }
}
