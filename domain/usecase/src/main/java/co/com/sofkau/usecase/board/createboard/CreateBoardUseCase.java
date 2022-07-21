package co.com.sofkau.usecase.board.createboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateBoardUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> createBoard(Board board){
        return boardRepository.save(board);
    }
}
