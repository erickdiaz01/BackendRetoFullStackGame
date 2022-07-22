package co.com.sofkau.model.card.gateways;

import co.com.sofkau.model.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardRepository {
     Mono<Card> save(Card card);
     Flux<Card> findAll();
     Mono<Card> findById(String idCard);
     Mono<Card> update(String idCard, Card card);
     Mono<Void> deleteById(String idCard);
}
