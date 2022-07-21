package co.com.sofkau.model.carta.gateways;

import co.com.sofkau.model.carta.Carta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartaRepository {
     Mono<Carta> save(Carta card);
     Flux<Carta> findAll();
     Mono<Carta> findById(String idCard);
     Mono<Carta> update(String idCard,Carta card);
     Mono<Void> deleteById(String idCard);
}
