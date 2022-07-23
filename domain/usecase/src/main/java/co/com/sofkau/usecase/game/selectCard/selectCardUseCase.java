package co.com.sofkau.usecase.game.selectCard;

import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;


@RequiredArgsConstructor
public class selectCardUseCase {
    private final GameRepository gameRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;
    public Mono<CardInGame> selectCard (String cardId , String playerId,String gameId){
          var game=  findGameByIdUseCase.findGameById(gameId).toFuture().join();
          var card= game.getPlayers().stream()
                  .filter(player -> player.getPlayerId().equals(playerId))
                  .flatMap(player -> player.getCards().stream())
                  .filter(cardInGames -> cardInGames.getCard().getCardId().equals(cardId))
                  .collect(Collectors.toList()).stream().findFirst().orElseThrow();


        return gameRepository.selectCard(card);
    }
}
