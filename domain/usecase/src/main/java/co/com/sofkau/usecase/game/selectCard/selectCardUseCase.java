package co.com.sofkau.usecase.game.selectCard;

import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.card.player.findplayerbyid.FindPlayerByIdUseCase;
import co.com.sofkau.usecase.game.findbyid.findGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;


@RequiredArgsConstructor
public class selectCardUseCase {
    private final GameRepository gameRepository;
    private final findGameByIdUseCase findGameByIdUseCase;
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
