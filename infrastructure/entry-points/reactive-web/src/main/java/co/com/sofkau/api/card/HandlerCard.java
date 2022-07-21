package co.com.sofkau.api.card;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.usecase.card.createcard.CreateCardUseCase;
import co.com.sofkau.usecase.card.deletecard.DeleteCardUseCase;
import co.com.sofkau.usecase.card.findallcards.FindAllCardsUseCase;
import co.com.sofkau.usecase.card.findcardbyid.FindCardByIdUseCase;
import co.com.sofkau.usecase.card.updatecard.UpdateCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerCard {
    private  final CreateCardUseCase createCardUseCase;
    private  final FindAllCardsUseCase findAllCardsUseCase;
    private final UpdateCardUseCase updateCardUseCase;
    private final FindCardByIdUseCase findCardByIdUseCase;
    private final DeleteCardUseCase deleteCardUseCase;

    public Mono<ServerResponse> createCard(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Carta.class)
                .flatMap(card -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(createCardUseCase.saveCard(card), Carta.class));

    }

    public Mono<ServerResponse> listCards(ServerRequest serverRequest) {
        Flux<Carta> card = findAllCardsUseCase.findAllCards();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON).body   (card, Carta.class);
    }

    public Mono<ServerResponse> updateCard(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Carta.class)
                .flatMap(card -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateCardUseCase.updateCard(id, card), Carta.class)
                );
    }

    public Mono<ServerResponse> findCardById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findCardByIdUseCase.findCardById(id),Carta.class);
    }

    public Mono<ServerResponse> deleteCardById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCardUseCase.deleteCardById(id), Carta.class);
    }
}


