package co.com.sofkau.usecase.board.deleteboard;

import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteBoardUseCase {
    private  final BoardRepository boardRepository;

    public Mono<Void> deleteBoardById(String boardId){
        return boardRepository.deleteById(boardId);
    }
}
