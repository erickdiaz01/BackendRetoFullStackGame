package co.com.sofkau.usecase.game.endgame;


import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EndGameUseCase {
    private final GameRepository gameRepository;


//    public Mono<Game> endGame(String gameId, Game game){
//        return gameRepository.findById(gameId);
////                .map(game1 -> {
////                    var winnerId = game.getPlayers().stream()
////                            .reduce((acumulator, player) -> {
////                               if (game.getBoard().getCardsInGame().size() == 11 - player.getCards().size()){                                    return player;
////                               } else {
////                                   return acumulator;
////                                }
////                            }).get();
////                           game.se
////                })
////
////    }
}
