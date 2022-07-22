package co.com.sofkau.api.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.usecase.board.changestateviewcards.ChangeStateViewCardsUseCase;
import co.com.sofkau.usecase.board.createboard.CreateBoardUseCase;
import co.com.sofkau.usecase.board.deleteboard.DeleteBoardUseCase;
import co.com.sofkau.usecase.board.findbyidboard.FindByIdBoardUseCase;
import co.com.sofkau.usecase.board.ifnotwinnerchangeround.IfNotWinnerChangeRoundUseCase;
import co.com.sofkau.usecase.board.receivecards.ReceiveCardsUseCase;
import co.com.sofkau.usecase.board.receivecardsofleftplayer.ReceiveCardsOfLeftPlayerUseCase;
import co.com.sofkau.usecase.board.selectroundwinner.SelectRoundWinnerUseCase;
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
    private final SelectRoundWinnerUseCase selectRoundWinnerUseCase;
    private final ReceiveCardsUseCase receiveCardsUseCase;
    private final ReceiveCardsOfLeftPlayerUseCase receiveCardsOfLeftPlayerUseCase;


    public Mono<ServerResponse> createBoard(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(createBoardUseCase.createBoard(board), Board.class));

    }

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
        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(changeStateViewCardsUseCase
                                .changeStateViewOfCards(id,board),Board.class));
    }

    public  Mono<ServerResponse> ifNotWinnerChangeRound(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(ifNotWinnerChangeRoundUseCase
                                .ifNotWinnerChangeRound(id,board),Board.class));
    }
    /*
    public  Mono<ServerResponse> selectRoundWinner(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Board.class)
                .flatMap(board -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(selectRoundWinnerUseCase
                                .selectRoundWinner(id,board),Board.class));
    }*/

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
