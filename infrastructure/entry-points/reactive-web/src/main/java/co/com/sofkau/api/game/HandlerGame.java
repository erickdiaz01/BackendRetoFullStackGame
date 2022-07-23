package co.com.sofkau.api.game;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.usecase.game.addPlayers.addPlayersUseCase;
import co.com.sofkau.usecase.game.countplayers.countPlayersUseCase;
import co.com.sofkau.usecase.game.creategame.createGameUseCase;
import co.com.sofkau.usecase.game.findallgame.findAllGameUseCase;
import co.com.sofkau.usecase.game.findbyid.findGameByIdUseCase;
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
    private final findGameByIdUseCase findGameByIdUseCase;
    private final addPlayersUseCase addPlayersUseCase;
    private final countPlayersUseCase countPlayersUseCase;


    public Mono<ServerResponse> createGame(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Game.class).flatMap(game ->
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(createGameUseCase.SaveGame(game),Game.class));
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
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(countPlayersUseCase.countPlayers(id,game),Game.class);
   }
}
