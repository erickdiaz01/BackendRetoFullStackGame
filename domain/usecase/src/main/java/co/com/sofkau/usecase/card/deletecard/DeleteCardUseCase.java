package co.com.sofkau.usecase.card.deletecard;

import co.com.sofkau.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCardUseCase {
    private final CartaRepository cartaRepository;

    public Mono<Void> deleteCardById(String cardId){
        return cartaRepository.deleteById(cardId);
    }
}
