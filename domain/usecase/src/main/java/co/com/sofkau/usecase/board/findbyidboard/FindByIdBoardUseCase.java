package co.com.sofkau.usecase.board.findbyidboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindByIdBoardUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> findBoardById(String boardId){
        return boardRepository.findById(boardId);
    }
}
