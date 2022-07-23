package co.com.sofkau.usecase.player.selectCard;

import co.com.sofkau.model.player.CardInGame;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.card.player.findplayerbyid.FindPlayerByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class selectCardUseCase {
    private final PlayerRepository playerRepository;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;
    public Mono<CardInGame> selectCard (String cardId ,String playerId){
          var player=  findPlayerByIdUseCase.findPlayerById(playerId).toFuture().join();
          var card= player.getCards().stream()
                   .filter(cardInGame -> cardInGame.getCard().getCardId().equals(cardId)).reduce((x,y)->{
                       return y;
                  }).orElseThrow();

        return playerRepository.selectCard(card);
    }
}
