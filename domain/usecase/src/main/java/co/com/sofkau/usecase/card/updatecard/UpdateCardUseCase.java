package co.com.sofkau.usecase.card.updatecard;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCardUseCase {
    private final CartaRepository cartaRepository;
   public Mono<Carta> updateCard(String cardId, Carta card){
        return cartaRepository.update(cardId,card);
    }
}
