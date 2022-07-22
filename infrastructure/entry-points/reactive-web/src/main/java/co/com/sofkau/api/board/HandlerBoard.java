package co.com.sofkau.api.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.usecase.board.createboard.CreateBoardUseCase;
import co.com.sofkau.usecase.board.deleteboard.DeleteBoardUseCase;
import co.com.sofkau.usecase.board.findbyidboard.FindByIdBoardUseCase;
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
}
