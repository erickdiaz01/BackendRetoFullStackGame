package co.com.sofkau.usecase.findcardbyid;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindCardByIdUseCase {
    private final CartaRepository cartaRepository;
    Mono<Carta> findCardById(String idCard){
        return cartaRepository.findById(idCard);
    }
}
