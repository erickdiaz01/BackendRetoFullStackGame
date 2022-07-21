package co.com.sofkau.usecase.card.findallcards;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCardsUseCase {
    private final CartaRepository cartaRepository;

    public Flux<Carta> findAllCards(){
        return cartaRepository.findAll();
    }
}
