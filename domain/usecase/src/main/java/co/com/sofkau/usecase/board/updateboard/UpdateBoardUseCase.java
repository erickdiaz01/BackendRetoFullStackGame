package co.com.sofkau.usecase.board.updateboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateBoardUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> updateBoard(String boardId, Board board){
        return boardRepository.update(boardId,board);
    }
}
