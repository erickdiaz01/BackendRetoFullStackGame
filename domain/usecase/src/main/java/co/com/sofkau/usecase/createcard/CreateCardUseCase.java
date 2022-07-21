package co.com.sofkau.usecase.createcard;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCardUseCase {
    private final CartaRepository cartaRepository;
    Mono<Carta> saveCard(Carta card) {
        return cartaRepository.save(card);
    }
}
