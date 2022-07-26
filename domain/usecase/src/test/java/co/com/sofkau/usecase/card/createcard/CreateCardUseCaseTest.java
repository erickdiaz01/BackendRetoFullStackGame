package co.com.sofkau.usecase.card.createcard;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;


class CreateCardUseCaseTest {
    @InjectMocks
    private CreateCardUseCase createCardUseCase;
    @Mock
    private CardRepository cardRepository;

   @BeforeEach
    void setUp() {MockitoAnnotations.openMocks(this);}


    @Test
    void cardCreation() {

       Card card = Card.builder()
               .cardId("1")
               .nameOfCard("Venom")
               .features("Aracnido")
               .urlImage(".com")
               .power(255)
               .build();
       when(cardRepository.save(card)).thenReturn(Mono.just(card));

        StepVerifier.create(createCardUseCase.saveCard(card)).assertNext(cardOne ->{
            Assertions.assertEquals("1",cardOne.getCardId());
            Assertions.assertEquals("Venom",cardOne.getNameOfCard());
            Assertions.assertEquals("Aracnido",cardOne.getFeatures());
            Assertions.assertEquals(".com",cardOne.getUrlImage());
            Assertions.assertEquals(255,cardOne.getPower());

        }).expectComplete().verify();

    }
}