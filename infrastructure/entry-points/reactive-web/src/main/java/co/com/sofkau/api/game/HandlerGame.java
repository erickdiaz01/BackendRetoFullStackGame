package co.com.sofkau.api.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.usecase.game.addPlayers.addPlayersUseCase;
import co.com.sofkau.usecase.game.betCard.betCardUseCase;
import co.com.sofkau.usecase.game.countplayers.countPlayersUseCase;
import co.com.sofkau.usecase.game.creategame.createGameUseCase;
import co.com.sofkau.usecase.game.dealcards.DealCardsUseCase;
import co.com.sofkau.usecase.game.findallgame.findAllGameUseCase;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import co.com.sofkau.usecase.game.selectroundwinner.SelectRoundWinnerUseCase;
import co.com.sofkau.usecase.game.verifyplayerlosed.VerifyPlayerLosedUseCase;
import co.com.sofkau.usecase.game.selectCard.selectCardUseCase;
import co.com.sofkau.usecase.game.surrenderPlayer.SurrenderPlayerUseCase;
import co.com.sofkau.usecase.game.winnergame.WinnerGameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerGame {
    private final createGameUseCase  createGameUseCase;
    private final findAllGameUseCase findallgameUseCase;
    private final FindGameByIdUseCase findGameByIdUseCase;
    private final addPlayersUseCase addPlayersUseCase;
    private final countPlayersUseCase countPlayersUseCase;
    private final DealCardsUseCase dealCardsUseCase;
    private final VerifyPlayerLosedUseCase verifyPlayerLosedUseCase;

    private final SurrenderPlayerUseCase surrenderPlayerUseCase;
    private  final selectCardUseCase selectCardUseCase;
    private final betCardUseCase betCardUseCase;
    private final WinnerGameUseCase winnerGameUseCase;
    private final SelectRoundWinnerUseCase selectRoundWinnerUseCase;

    public Mono<ServerResponse> createGame(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Game.class).flatMap(game ->
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(createGameUseCase.SaveGame(game),Game.class));
    }

    public Mono<ServerResponse> listGame(ServerRequest serverRequest){
        Flux<Game> game = findallgameUseCase.ListGame();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(game , Game.class);
    }

    public Mono<ServerResponse> addPlayersGame(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Game.class).flatMap(game->
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(addPlayersUseCase.savePlayer(id,game),Game.class));
    }

    public Mono<ServerResponse> findGameById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findGameByIdUseCase.findGameById(id), Game.class);
    }
   public Mono<ServerResponse> countPlayers(ServerRequest serverRequest){
       String id = serverRequest.pathVariable("id");
       Game game = findGameByIdUseCase.findGameById(id).toFuture().join();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(countPlayersUseCase.countPlayers(id,game),Game.class);
   }

   public Mono<ServerResponse> surrenderPlayer(ServerRequest serverRequest){
        String playerId = serverRequest.pathVariable("playerId");
        String gameId = serverRequest.pathVariable("gameId");

        Game game = findGameByIdUseCase.findGameById(gameId).toFuture().join();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(surrenderPlayerUseCase.surrenderPlayer(playerId, game, gameId),Game.class);
   }

    public Mono<ServerResponse> dealCards(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Game game = findGameByIdUseCase.findGameById(id).toFuture().join();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(dealCardsUseCase.dealCards(id,game),Game.class);
    }
    public Mono<ServerResponse> verifyPlayersLosed(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Game game = findGameByIdUseCase.findGameById(id).toFuture().join();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(verifyPlayerLosedUseCase.verifyPlayerLosed(id, game), Game.class);

    }
    
    public Mono<ServerResponse> selectCard(ServerRequest serverRequest){
        String playerId = serverRequest.pathVariable("playerId");
        String cardId = serverRequest.pathVariable("cardId");
        String gameId = serverRequest.pathVariable("gameId");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(selectCardUseCase.selectCard(cardId,playerId,gameId),Game.class);
    }
    public Mono<ServerResponse> betCardPlayer(ServerRequest serverRequest){
        String playerId = serverRequest.pathVariable("playerId");
        String cardId = serverRequest.pathVariable("cardId");
        String gameId = serverRequest.pathVariable("gameId");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(betCardUseCase.betCardPlayer(gameId,playerId,cardId),Game.class);
    }
    public Mono<ServerResponse> winnerGame(ServerRequest serverRequest){
        String gameId = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(winnerGameUseCase.winnerGame(gameId),Game.class);
    }
    public  Mono<ServerResponse> selectRoundWinner(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Game game = findGameByIdUseCase.findGameById(id).toFuture().join();
        return serverRequest.bodyToMono(Game.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(selectRoundWinnerUseCase
                                .selectRoundWinner(id,game),Game.class));
    }
}
