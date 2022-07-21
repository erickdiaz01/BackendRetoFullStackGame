package co.com.sofkau.api.player;



import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.player.createplayer.CreatePlayerUseCase;
import co.com.sofkau.usecase.player.deleteplayer.DeletePlayerUseCase;
import co.com.sofkau.usecase.player.findallplayers.FindAllPlayersUseCase;
import co.com.sofkau.usecase.player.findplayerbyid.FindPlayerByIdUseCase;
import co.com.sofkau.usecase.player.updateplayer.UpdatePlayerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerPlayer {

    private final CreatePlayerUseCase createPlayerUseCase;
    private final FindAllPlayersUseCase findAllPlayersUseCase;
    private final UpdatePlayerUseCase updatePlayerUseCase;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;
    private final DeletePlayerUseCase deletePlayerUseCase;

    public Mono<ServerResponse> createPlayer(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Player.class)
                .flatMap(player -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(createPlayerUseCase.createPlayer(player), Player.class));

    }

    public Mono<ServerResponse> updatePlayer(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Player.class)
                .flatMap(player -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updatePlayerUseCase.updatePlayer(id, player), Player.class)
                );
    }

    public Mono<ServerResponse> findPlayerById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findPlayerByIdUseCase.findPlayerById(id),Player.class);
    }

    public Mono<ServerResponse> deletePlayerById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deletePlayerUseCase.deletePlayerById(id), Board.class);
    }

    public Mono<ServerResponse> findAllPlayers(ServerRequest serverRequest) {
        Flux<Player> player = findAllPlayersUseCase.findAllPlayers();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON).body(player, Player.class);
    }

}
