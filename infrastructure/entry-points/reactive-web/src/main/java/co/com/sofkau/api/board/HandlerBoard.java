package co.com.sofkau.api.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.usecase.board.changestateviewcards.ChangeStateViewCardsUseCase;
import co.com.sofkau.usecase.board.createboard.CreateBoardUseCase;
import co.com.sofkau.usecase.board.deleteboard.DeleteBoardUseCase;
import co.com.sofkau.usecase.board.findbyidboard.FindByIdBoardUseCase;
import co.com.sofkau.usecase.board.ifnotwinnerchangeround.IfNotWinnerChangeRoundUseCase;
import co.com.sofkau.usecase.board.receivecards.ReceiveCardsUseCase;
import co.com.sofkau.usecase.board.receivecardsofleftplayer.ReceiveCardsOfLeftPlayerUseCase;
import co.com.sofkau.usecase.board.updateboard.UpdateBoardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerBoard {
    private final CreateBoardUseCase createBoardUseCase;
    private final DeleteBoardUseCase deleteBoardUseCase;
    private final UpdateBoardUseCase updateBoardUseCase;
    private final FindByIdBoardUseCase findByIdBoardUseCase;

    private final ChangeStateViewCardsUseCase changeStateViewCardsUseCase;
    private final IfNotWinnerChangeRoundUseCase ifNotWinnerChangeRoundUseCase;

    private final ReceiveCardsUseCase receiveCardsUseCase;
    private final ReceiveCardsOfLeftPlayerUseCase receiveCardsOfLeftPlayerUseCase;

    /**
     * Método para Crear un tablero utilizando un Mono de tipo Server Response, recibe el
     * @param serverRequest, es decir, se recibe desde el body y se transforma a un flujo
     * Mono asincrono de tipo Board, luego se usa flatmap para aplanarlo y una arrow function
     * para recorrer dicho flujo del body llamando al caso de uso del tablero pasnadole el board y.
     * @return  el resultado de dicha petición
     */
    public Mono<ServerResponse> createBoard(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(createBoardUseCase.createBoard(board), Board.class));

    }

    /**
     * Método para actualizar un tablero utilizando un Mono de tipo Server Response, recibe el
     * @param serverRequest, para este método se declara una variable "ID" para envarla en el path url
     * se recibe desde el body y se transforma a un flujo Mono asincrono de tipo Board, luego se usa
     * flatmap para aplanarlo y una arrow function
     * para recorrer dicho flujo del body llamando al caso de uso del update del caso de uso tablero,
     * para este caso se envía como parámetro el id del tablero y el objeto tablero.
     * @return  el resultado de dicha petición de clase Board
     */
    public Mono<ServerResponse> updateBoard(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateBoardUseCase.updateBoard(id, board), Board.class)
                );
    }

    public Mono<ServerResponse> findBoardById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findByIdBoardUseCase.findBoardById(id),Board.class);
    }

    public Mono<ServerResponse> deleteBoardById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteBoardUseCase.deleteBoardById(id), Board.class);
    }
    public Mono<ServerResponse> changeStateViewCards(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Board board = findByIdBoardUseCase.findBoardById(id).toFuture().join();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(changeStateViewCardsUseCase.changeStateViewOfCards(id,board), Game.class);
    }
    public  Mono<ServerResponse> ifNotWinnerChangeRound(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(ifNotWinnerChangeRoundUseCase
                                .ifNotWinnerChangeRound(id,board),Board.class));
    }



    public  Mono<ServerResponse> receiveCards(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(receiveCardsUseCase.receiveCards
                                (id,board),Board.class));
    }

    public  Mono<ServerResponse> receiveCardsOfLeftPlayer(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(receiveCardsOfLeftPlayerUseCase.receiveCardsOfLeftPlayer
                                (id,board),Board.class));
    }







}
