package co.com.sofkau.usecase.findallcards;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCardsUseCase {
    private final CartaRepository cartaRepository;

    Flux<Carta> findAllCards(){
        return cartaRepository.findAll();
    }
}
