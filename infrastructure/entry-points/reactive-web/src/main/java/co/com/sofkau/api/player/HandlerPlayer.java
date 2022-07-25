package co.com.sofkau.api.player;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.player.createplayer.CreatePlayerUseCase;
import co.com.sofkau.usecase.player.deleteplayer.DeletePlayerUseCase;
import co.com.sofkau.usecase.player.findallplayers.FindAllPlayersUseCase;
import co.com.sofkau.usecase.player.findplayerbyid.FindPlayerByIdUseCase;
import co.com.sofkau.usecase.player.updateplayer.UpdatePlayerUseCase;
import co.com.sofkau.usecase.player.addglobalscore.AddGlobalScoreUseCase;
import co.com.sofkau.usecase.player.assigncardtoplayer.AssignCardToPlayerUseCase;
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

    private final AssignCardToPlayerUseCase assignCardToPlayerUseCase;

private final AddGlobalScoreUseCase addGlobalScoreUseCase;


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
                .body(deletePlayerUseCase.deletePlayerById(id), Player.class);
    }

    public Mono<ServerResponse> findAllPlayers(ServerRequest serverRequest) {
        Flux<Player> player = findAllPlayersUseCase.findAllPlayers();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON).body(player, Player.class);
    }

    public Mono<ServerResponse> createPlayer(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Player.class)
                .flatMap(player -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(createPlayerUseCase.createPlayer(player), Game.class));

    }
    public Mono<ServerResponse> assignCardToPlayer(ServerRequest serverRequest){
        String playerId = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Player.class)
                .flatMap(player -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(assignCardToPlayerUseCase.assignCardToPlayer(playerId,player), Player.class));
    }

    public Mono<ServerResponse> addGlobalScore(ServerRequest serverRequest) {
        String playerId = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON).body(addGlobalScoreUseCase.addGlobalScore(playerId), Player.class);
    }

}
